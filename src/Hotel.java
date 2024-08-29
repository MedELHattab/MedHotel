import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findAvailableRoom() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                return room;
            }
        }
        return null;  // No available room
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.getRoom().bookRoom();
    }

    public void cancelReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservation.cancelReservation();
                reservations.remove(reservation);
                break;
            }
        }
    }

    public void getReservationDetails(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                System.out.println("Reservation Details:");
                System.out.println("Guest Name: " + reservation.getGuestName());
                System.out.println("Room Number: " + reservation.getRoom().getRoomNumber());
                System.out.println("Check-In Date: " + reservation.getCheckInDate());
                System.out.println("Check-Out Date: " + reservation.getCheckOutDate());
            }
        }
    }
}
