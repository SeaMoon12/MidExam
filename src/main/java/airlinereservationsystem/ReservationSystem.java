package airlinereservationsystem;

public class ReservationSystem {
    private Flight[] availableFlights;

    public ReservationSystem() {
        availableFlights = new Flight[] {
                new Flight(1, "Flight A", "New York", "Los Angeles", 200),
                new Flight(2, "Flight B", "Chicago", "San Francisco", 250),
                new Flight(3, "Flight C", "Miami", "Houston", 180),
                new Flight(4, "Flight D", "Seattle", "Dallas", 220),
        };
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : availableFlights) {
            System.out.println(flight.id + ". " + flight.getFlightDetails() + " - $" + flight.getPricePerTicket());
        }
    }

    public double calculateTotalPrice(int flightId, int numOfTickets) {
        Flight selectedFlight = availableFlights[flightId - 1];
        return selectedFlight.getPricePerTicket() * numOfTickets;
    }

    public void printReceipt(int flightId, int numOfTickets) {
        Flight selectedFlight = availableFlights[flightId - 1];
        double totalPrice = calculateTotalPrice(flightId, numOfTickets);
        System.out.println("\n=== RECEIPT ===");
        System.out.println("Flight: " + selectedFlight.getFlightDetails());
        System.out.println("Number of Tickets: " + numOfTickets);
        System.out.println("Total Price: $" + totalPrice);
    }
}
