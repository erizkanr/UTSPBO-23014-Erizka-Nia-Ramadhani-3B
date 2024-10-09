/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author abdul rohim
 */
public class Admin extends User {
    // Constructor
    public Admin(String name) {
        super(name, "Admin");
    }

    // Admin dapat menambahkan fitur tambahan, seperti mengelola kamar
    public void manageRoom(Room room, boolean availability) {
        room.setAvailable(availability);
        System.out.println("Room " + room.getRoomNumber() + " availability changed to: " + (availability ? "Available" : "Not Available"));
    }
}