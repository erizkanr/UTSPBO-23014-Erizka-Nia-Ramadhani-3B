/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author abdul rohim
 */
public class Customer extends User implements Reservable {
    // Constructor
    public Customer(String name) {
        super(name, "Customer");
    }

    @Override
    public void reserveRoom(Room room) {
        if (room.isAvailable()) {
            room.setAvailable(false);
            System.out.println("Room " + room.getRoomNumber() + " successfully reserved by " + this.name);
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not available.");
        }
    }

    @Override
    public void cancelReservation(Room room) {
        if (!room.isAvailable()) {
            room.setAvailable(true);
            System.out.println("Reservation for Room " + room.getRoomNumber() + " has been canceled by " + this.name);
        } else {
            System.out.println("No reservation to cancel for Room " + room.getRoomNumber());
        }
    }
}