package airlinereservationsystem;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.println("=== WELCOME TO AIRLINE TICKET RESERVATION SYSTEM ===");

        // Display available flights
        reservationSystem.displayAvailableFlights();

        // Choose flight
        System.out.print("Select a flight (Enter flight ID): ");
        int flightId = scanner.nextInt();

        if (flightId < 1 || flightId > reservationSystem.getNumOfFlights()) {
            System.out.println("Invalid airline ID. Program terminated.");
            System.exit(0); // https://stackoverflow.com/questions/22452930/terminating-a-java-program
        }

        reservationSystem.displayAvailableClasses();

        // Choose class
        System.out.print("Select a flight class (Enter class ID): ");
        int flightClass = scanner.nextInt();

        // Input number of tickets
        System.out.print("How many tickets do you want to book? ");
        int numOfTickets = scanner.nextInt();

        reservationSystem.displayAvailablePaymentMethods();

        // Choose payment method
        System.out.print("Select a payment method (Enter payment ID): ");
        int paymentMethod = scanner.nextInt();

        // Display receipt
        reservationSystem.printReceipt(flightId, numOfTickets, flightClass, paymentMethod);

        scanner.close();
    }
}
