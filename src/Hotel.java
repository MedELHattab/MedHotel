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

    public List<Room> findAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);  // Collect all available rooms
            }
        }
        return availableRooms;  // Return the list of all available rooms
    }


    public Room findRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomId) {
                return room;
            }
        }
        return null;  // No room found with the given ID
    }

    public boolean addReservation(Reservation reservation) {
        // Check if the room is available for the specified period
        for (Reservation existingReservation : reservations) {
            if (existingReservation.getRoom().equals(reservation.getRoom()) &&
                    !(reservation.getCheckOutDate().before(existingReservation.getCheckInDate()) ||
                            reservation.getCheckInDate().after(existingReservation.getCheckOutDate()))) {
                System.out.println("Room is not available for the requested period.");
                return false;
            }
        }
        // If available, add the reservation and book the room
        reservations.add(reservation);
        reservation.getRoom().bookRoom();
        return false;
    }

    public void cancelReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservation.getRoom().releaseRoom();
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

    public int getNextReservationId() {
        return reservations.size() + 1;
    }

    public Reservation getReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;  // Return null if not found
    }
}
