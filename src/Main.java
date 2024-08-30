import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");


        while (true) {
            // Display the menu
            System.out.println("Hotel Management System");
            System.out.println("1. Add Room");
            System.out.println("2. View Available Room");
            System.out.println("3. Create Reservation");
            System.out.println("4. Change Reservation");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. View Reservation Details");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Room
                    System.out.print("Enter Room Number: ");
                    int roomNumber = scanner.nextInt();
                    Room room = new Room(roomNumber);
                    hotel.addRoom(room);
                    System.out.println("Room " + roomNumber + " added successfully.");
                    break;

                case 2:
                    // View Available Rooms
                    List<Room> availableRooms = hotel.findAvailableRooms();
                    if (!availableRooms.isEmpty()) {  // Check if there are any available rooms
                        System.out.println("Available Rooms:");
                        for (Room rooms : availableRooms) {
                            System.out.println("Room Number: " + rooms.getRoomNumber());
                        }
                    } else {
                        System.out.println("No rooms are available.");
                    }
                    break;


                case 3:
                    // Create Reservation
                    System.out.print("Enter Room Number for Reservation: ");
                    int reserveRoomNumber = scanner.nextInt();
                    Room selectedRoom = hotel.findRoomById(reserveRoomNumber);

                    if (selectedRoom != null && selectedRoom.isAvailable()) {
                        System.out.print("Enter Guest Name: ");
                        scanner.nextLine(); // Consume the leftover newline
                        String guestName = scanner.nextLine();

                        System.out.print("Enter check-in date (MM/DD/YYYY): ");
                        String checkInStr = scanner.nextLine();
                        Date checkInDate;
                        try {
                            checkInDate = dateFormat.parse(checkInStr);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please use MM/DD/YYYY.");
                            continue; // Skip this iteration
                        }

                        System.out.print("Enter check-out date (MM/DD/YYYY): ");
                        String checkOutStr = scanner.nextLine();
                        Date checkOutDate;
                        try {
                            checkOutDate = dateFormat.parse(checkOutStr);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please use MM/DD/YYYY.");
                            continue; // Skip this iteration
                        }

                        // Check if check-out date is after check-in date
                        if (checkOutDate.before(checkInDate)) {
                            System.out.println("Check-out date must be after check-in date.");
                            continue; // Skip this iteration
                        }

                        Reservation reservation = new Reservation(hotel.getNextReservationId(), guestName, selectedRoom, checkInDate, checkOutDate);
                        if (hotel.addReservation(reservation)) {
                            System.out.println("Reservation created successfully for Room " + reserveRoomNumber);
                        } else {
                            System.out.println("Failed to create reservation. Room " + reserveRoomNumber + " might not be available.");
                        }
                    } else {
                        System.out.println("Room " + reserveRoomNumber + " is not available or does not exist.");
                    }
                    break;


                case 4:
                    // Change Reservation
                    System.out.print("Enter Reservation ID to modify: ");
                    int reservationId = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer

                    System.out.print("Enter new check-in date (MM/DD/YYYY): ");
                    String newCheckInStr = scanner.nextLine();
                    Date newCheckInDate;
                    try {
                        newCheckInDate = dateFormat.parse(newCheckInStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use MM/DD/YYYY.");
                        continue; // Skip this iteration
                    }

                    System.out.print("Enter new check-out date (MM/DD/YYYY): ");
                    String newCheckOutStr = scanner.nextLine();
                    Date newCheckOutDate;
                    try {
                        newCheckOutDate = dateFormat.parse(newCheckOutStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use MM/DD/YYYY.");
                        continue; // Skip this iteration
                    }

                    // Find the reservation and modify it
                    Reservation reservation = hotel.getReservationById(reservationId);
                    if (reservation != null) {
                        reservation.modifyReservation(newCheckInDate, newCheckOutDate);
                        System.out.println("Reservation modified successfully.");
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;


                case 5:
                    // Cancel Reservation
                    System.out.print("Enter Reservation ID to Cancel: ");
                    int reservationID = scanner.nextInt();
                    hotel.cancelReservation(reservationID);
                    System.out.println("Reservation " + reservationID + " cancelled successfully.");
                    break;

                case 6:
                    // View Reservation Details
                    System.out.print("Enter Reservation ID to View: ");
                    int viewReservationId = scanner.nextInt();
                    hotel.getReservationDetails(viewReservationId);
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
