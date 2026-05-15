package airlinereservationsystem;

public class Flight {
    int id;
    String flightName;
    String origin;
    String destination;
    int pricePerTicket;

    public Flight(int id, String flightName, String origin, String destination, int pricePerTicket) {
        this.id = id;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.pricePerTicket = pricePerTicket;
    }

    public String getFlightName() {
        return flightName;
    }

    public int getPricePerTicket() {
        return pricePerTicket;
    }

    public String getFlightDetails() {
        return flightName + " (" + origin + " to " + destination + ")";
    }
}
