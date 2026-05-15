package airlinereservationsystem;

public class Transaction {
    String name;
    String airline;
    String destination;
    int ticketQuantity;
    String flightClass;
    int totalPayment;

    public Transaction(String name, String airline, String destination, int ticketQuantity, String flightClass, int totalPayment) {
        this.name = name;
        this.airline = airline;
        this.destination = destination;
        this.ticketQuantity = ticketQuantity;
        this.flightClass = flightClass;
        this.totalPayment = totalPayment;
    }

    public String displayTransaction() {
        return "Name: " + name + "\n" +
                "Airline: " + airline + "\n" +
                "Destination: " + destination + "\n" +
                "Ticket Quantity: " + ticketQuantity + "\n" +
                "Flight Class: " + flightClass + "\n" +
                "Total Payment: " + totalPayment + "\n";
    }
}
