import java.util.Date;

public class Reservation {
    private final int reservationId;
    private String guestName;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(int reservationId, String guestName, Room room, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void modifyReservation(Date newCheckInDate, Date newCheckOutDate) {
        this.checkInDate = newCheckInDate;
        this.checkOutDate = newCheckOutDate;
    }

    public void cancelReservation() {
        room.releaseRoom();
    }
}

