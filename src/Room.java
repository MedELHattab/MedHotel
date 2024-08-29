public class Room {
    private final int roomNumber;
    private boolean isAvailable;


    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;  // Par défaut, la chambre est disponible

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        if (isAvailable) {
            this.isAvailable = false;
        } else {
            System.out.println("La chambre est déjà réservée.");
        }
    }

    public void releaseRoom() {
        this.isAvailable = true;
    }
}
