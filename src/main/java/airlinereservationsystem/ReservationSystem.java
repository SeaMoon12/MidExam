package airlinereservationsystem;

import java.util.ArrayList;

public class ReservationSystem {
    private Flight[] availableFlights;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private double discount = 0;
    private double vat = 0;

    public ReservationSystem() {
        availableFlights = new Flight[] {
                new Flight(1, "Flight A", "New York", "Los Angeles", 200),
                new Flight(2, "Flight B", "Chicago", "San Francisco", 250),
                new Flight(3, "Flight C", "Miami", "Houston", 180),
                new Flight(4, "Flight D", "Seattle", "Dallas", 220),
                new Flight(5, "Flight E", "Jakarta", "Bali", 400)
        };
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : availableFlights) {
            System.out.println(flight.id + ". " + flight.getFlightDetails() + " - $" + flight.getPricePerTicket());
        }
    }

    public double calculateTotalPrice(int flightId, int numOfTickets, int flightClass) {
        Flight selectedFlight = availableFlights[flightId - 1];
        double totalPrice = 0;
        double ECONOMY_MULTIPLIER = 1.0;
        double BUSINESS_MULTIPLIER = 1.25;
        double FIRST_CLASS_MULTIPLIER = 1.5;
        double econDiscount = 0.1;
        totalPrice = selectedFlight.getPricePerTicket() * numOfTickets;
        switch(flightClass) {
            case 1:
                totalPrice = totalPrice * ECONOMY_MULTIPLIER;
                if (numOfTickets > 5) {
                    discount = totalPrice * econDiscount;
                }
                break;
            case 2:
                totalPrice = totalPrice * BUSINESS_MULTIPLIER;
                break;
            case 3:
                totalPrice = totalPrice * FIRST_CLASS_MULTIPLIER;
                break;
        }
        vat = 0.11 * totalPrice;
        totalPrice += vat; // apply VAT
        totalPrice -= discount; // apply discount
        return totalPrice;
    }

    public void printReceipt(int flightId, int numOfTickets, int flightClass, int paymentMethod, String name) {
        Flight selectedFlight = availableFlights[flightId - 1];
        double totalPrice = calculateTotalPrice(flightId, numOfTickets, flightClass);
        System.out.println("\n=== RECEIPT ===");
        System.out.println("Flight: " + selectedFlight.getFlightDetails());
        System.out.println("Number of Tickets: " + numOfTickets);
        System.out.println("VAT: " + vat);
        System.out.println("Discount: " + "- " + discount);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Payment Method: " + getPaymentMethod(paymentMethod));
        transactions.add(new Transaction(name, selectedFlight.getFlightName(), selectedFlight.destination, numOfTickets, getFlightClass(flightClass), totalPrice));
        vat = 0;
        discount = 0;
    }

    private String getFlightClass(int flightClass) {
        switch(flightClass) {
            case 1:
                return "Economy Class";
            case 2:
                return "Business Class";
            case 3:
                return "First Class";
        }
        return "";
    }

    private String getPaymentMethod(int paymentMethod) {
        String method = "";
        switch (paymentMethod) {
            case 1:
                method = "Cash";
                break;
            case 2:
                method = "Bank Transfer";
                break;
            case 3:
                method = "eWallet";
                break;
        }
        return method;
    }

    public void displayAvailableClasses() {
        System.out.println("\nAvailable Classes:");
        System.out.println("1. Economy Class");
        System.out.println("2. Business Class");
        System.out.println("3. First Class");
    }

    public void displayAvailablePaymentMethods() {
        System.out.println("\nAvailable Payment Methods:");
        System.out.println("1. Cash");
        System.out.println("2. Bank Transfer");
        System.out.println("3. eWallet");
    }

    public int getNumOfFlights() {
        int numOfFlights = 0;
        for (Flight flight : availableFlights) {
            numOfFlights++;
        }
        return numOfFlights;
    }

    public void displayTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println("Name\tairline\t\tdestination\t\tticket quantity\t\tFlight Class\tTotal Payment");
            System.out.println(transaction.displayTransaction());
        }
    }
}
