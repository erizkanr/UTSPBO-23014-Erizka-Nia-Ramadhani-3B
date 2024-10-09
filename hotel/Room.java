/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author abdul rohim
 */
public class Room {
    private String roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double price;

    // Constructor
    public Room(String roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true; // Awalnya semua kamar tersedia
        this.price = price;
    }

    // Getter
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Method untuk detail kamar
    public String getRoomDetails() {
        return "Room " + roomNumber + " (" + roomType + ") - Price: $" + price + " - Available: " + (isAvailable ? "Yes" : "No");
    }
}
