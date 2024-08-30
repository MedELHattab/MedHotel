# Hotel Reservation Management System

This is a simple console-based Hotel Reservation Management System built in Java. The application allows users to manage hotel rooms and reservations, including creating, modifying, and canceling reservations, as well as viewing available rooms.

## Features

- **Room Management**: Add rooms to the hotel and check their availability.
- **Reservation Management**: Create, modify, and cancel reservations. View reservation details.
- **Date Validation**: Ensure that reservations are made for valid dates.
- **Menu-Driven Interface**: Navigate through the application using a simple menu.

## Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/MedELHattab/MedHotel.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd MedHotel
    ```

3. **Compile the Java files:**

    ```bash
    javac Main.java Hotel.java Room.java Reservation.java
    ```

4. **Run the application:**

    ```bash
    java Main
    ```

## Usage

After running the application, a menu will be displayed with the following options:

1. **Add Room**: Add a new room to the hotel by entering the room number.
2. **View Available Room**: Display a list of rooms that are currently available.
3. **Create Reservation**: Create a new reservation by selecting an available room and entering the guest's details.
4. **Change Reservation**: Modify an existing reservation's check-in and check-out dates.
5. **Cancel Reservation**: Cancel an existing reservation by providing the reservation ID.
6. **View Reservation Details**: View details of a reservation by providing the reservation ID.
7. **Exit**: Exit the application.

### Date Format

When entering dates for reservations, use the following format: `MM/DD/YYYY` (e.g., `12/25/2024`).

### Example Workflow

1. Start the application.
2. Add a few rooms to the hotel.
3. Create a reservation by selecting an available room and entering the check-in and check-out dates.
4. Modify or cancel the reservation if needed.
5. View details of a reservation or check the availability of rooms.

## Classes and Methods

### `Room`

- `int getRoomNumber()`: Returns the room number.
- `boolean isAvailable()`: Checks if the room is available.
- `void bookRoom()`: Marks the room as booked.
- `void releaseRoom()`: Marks the room as available.

### `Reservation`

- `int getReservationId()`: Returns the reservation ID.
- `Room getRoom()`: Returns the room associated with the reservation.
- `void modifyReservation(Date newCheckInDate, Date newCheckOutDate)`: Modifies the check-in and check-out dates of the reservation.

### `Hotel`

- `void addRoom(Room room)`: Adds a room to the hotel.
- `List<Room> findAvailableRooms()`: Returns a list of all available rooms.
- `Room findRoomById(int roomId)`: Finds a room by its room number.
- `boolean addReservation(Reservation reservation)`: Adds a reservation if the room is available for the requested period.
- `void cancelReservation(int reservationId)`: Cancels an existing reservation.
- `Reservation getReservationById(int reservationId)`: Retrieves a reservation by its ID.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue if you have any suggestions or find any bugs.

## Contact

For any questions or inquiries, please contact [elhattabmohammedelarbi@gmail.com].

