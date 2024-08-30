import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("Hotel Management System");
            System.out.println("1. Add Room");
            System.out.println("2. View Available Room");
            System.out.println("3. Create Reservation");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View Reservation Details");
            System.out.println("6. Exit");
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
                        scanner.nextLine(); // consume the leftover newline
                        String guestName = scanner.nextLine();

                        Date checkInDate = new Date();  // current date/time
                        Date checkOutDate = new Date(checkInDate.getTime() + 2 * 24 * 60 * 60 * 1000);  // 2 days later

                        Reservation reservation = new Reservation(hotel.getNextReservationId(), guestName, selectedRoom, checkInDate, checkOutDate);
                        hotel.addReservation(reservation);
                        System.out.println("Reservation created successfully for Room " + reserveRoomNumber);
                    } else {
                        System.out.println("Room " + reserveRoomNumber + " is not available or does not exist.");
                    }
                    break;

                case 4:
                    // Cancel Reservation
                    System.out.print("Enter Reservation ID to Cancel: ");
                    int reservationId = scanner.nextInt();
                    hotel.cancelReservation(reservationId);
                    System.out.println("Reservation " + reservationId + " cancelled successfully.");
                    break;

                case 5:
                    // View Reservation Details
                    System.out.print("Enter Reservation ID to View: ");
                    int viewReservationId = scanner.nextInt();
                    hotel.getReservationDetails(viewReservationId);
                    break;

                case 6:
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
