package airlinereservationsystem;

public class Transaction {
    String name;
    String airline;
    String destination;
    int ticketQuantity;
    String flightClass;
    double totalPayment;

    public Transaction(String name, String airline, String destination, int ticketQuantity, String flightClass, double totalPayment) {
        this.name = name;
        this.airline = airline;
        this.destination = destination;
        this.ticketQuantity = ticketQuantity;
        this.flightClass = flightClass;
        this.totalPayment = totalPayment;
    }

    public String displayTransaction() {
        return name + "\t" + airline + "\t" + destination + "        \t\t" + ticketQuantity + "\t\t\t" + flightClass + "\t\t" + totalPayment;
    }
}
