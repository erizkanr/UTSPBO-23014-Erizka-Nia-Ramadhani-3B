/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;
import java.util.Scanner;
/**
 *
 * @author abdul rohim
 */
public class HotelApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Membuat beberapa kamar hotel
        Room room1 = new Room("101", "Single", 100);
        Room room2 = new Room("102", "Double", 150);
        Room room3 = new Room("103", "Suite", 250);

        Scanner scanner = new Scanner(System.in);

        // Pilih akses: Admin atau Customer
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.print("Select your role: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        User user;
        if (roleChoice == 1) {
            System.out.print("Enter admin name: ");
            String adminName = scanner.nextLine();
            user = new Admin(adminName);

            System.out.println("Hello Admin, what do you want to do?");
            System.out.println("1. Check room availability");
            System.out.println("2. Change room availability");
            int adminChoice = scanner.nextInt();

            if (adminChoice == 1) {
                System.out.println(room1.getRoomDetails());
                System.out.println(room2.getRoomDetails());
                System.out.println(room3.getRoomDetails());
            } else if (adminChoice == 2) {
                System.out.println("Enter room number to change availability (101, 102, 103): ");
                String roomNumber = scanner.next();
                Room selectedRoom = getRoomByNumber(roomNumber, room1, room2, room3);

                if (selectedRoom != null) {
                    System.out.println("Set availability for room " + roomNumber + " (true for available, false for not): ");
                    boolean availability = scanner.nextBoolean();
                    ((Admin) user).manageRoom(selectedRoom, availability);
                } else {
                    System.out.println("Invalid room number.");
                }
            }

        } else if (roleChoice == 2) {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            user = new Customer(customerName);

            System.out.println("Hello Customer, what do you want to do?");
            System.out.println("1. Reserve a room");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Check room availability");
            int customerChoice = scanner.nextInt();

            if (customerChoice == 1) {
                System.out.println("Enter room number to reserve (101, 102, 103): ");
                String roomNumber = scanner.next();
                Room selectedRoom = getRoomByNumber(roomNumber, room1, room2, room3);

                if (selectedRoom != null) {
                    ((Customer) user).reserveRoom(selectedRoom);
                } else {
                    System.out.println("Invalid room number.");
                }
            } else if (customerChoice == 2) {
                System.out.println("Enter room number to cancel reservation (101, 102, 103): ");
                String roomNumber = scanner.next();
                Room selectedRoom = getRoomByNumber(roomNumber, room1, room2, room3);

                if (selectedRoom != null) {
                    ((Customer) user).cancelReservation(selectedRoom);
                } else {
                    System.out.println("Invalid room number.");
                }
            } else if (customerChoice == 3) {
                System.out.println(room1.getRoomDetails());
                System.out.println(room2.getRoomDetails());
                System.out.println(room3.getRoomDetails());
            }
        }

        scanner.close();
    }

    private static Room getRoomByNumber(String roomNumber, Room... rooms) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }
}
