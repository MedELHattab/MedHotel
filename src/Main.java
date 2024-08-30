import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create a Hotel instance
        Hotel hotel = new Hotel();

        // Create some Room objects and add them to the hotel
        Room room101 = new Room(101);
        Room room102 = new Room(102);
        Room room103 = new Room(103);

        hotel.addRoom(room101);
        hotel.addRoom(room102);
        hotel.addRoom(room103);

        // Find an available room
        Room availableRoom = hotel.findAvailableRoom();
        if (availableRoom != null) {
            System.out.println("Available Room Number: " + availableRoom.getRoomNumber());
        } else {
            System.out.println("No rooms are available.");
        }

        // Create a Reservation
        Date checkInDate = new Date();  // current date/time
        Date checkOutDate = new Date(checkInDate.getTime() + 2 * 24 * 60 * 60 * 1000);  // 2 days later

        Reservation reservation1 = new Reservation(1, "John Doe", availableRoom, checkInDate, checkOutDate);

        Date checkInDate2 = new Date();  // current date/time
        Date checkOutDate2 = new Date(checkInDate.getTime() + 2 * 24 * 60 * 60 * 1000);  // 2 days later

        Reservation reservation2 = new Reservation(1, "John Doe", availableRoom, checkInDate2, checkOutDate2);
        // Add the reservation to the hotel
        hotel.addReservation(reservation1);
        hotel.addReservation(reservation2);
        // Retrieve reservation details
        hotel.getReservationDetails(1);
        hotel.getReservationDetails(2);
        // Cancel the reservation
        hotel.cancelReservation(1);

        // Check the room's availability again
        if (availableRoom.isAvailable()) {
            System.out.println("Room " + availableRoom.getRoomNumber() + " is now available.");
        } else {
            System.out.println("Room " + availableRoom.getRoomNumber() + " is still booked.");
        }
    }
}
