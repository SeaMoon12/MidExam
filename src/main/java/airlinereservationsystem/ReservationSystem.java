package airlinereservationsystem;

public class ReservationSystem {
    private Flight[] availableFlights;

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
        switch(flightClass) {
            case 1:
                totalPrice = selectedFlight.getPricePerTicket() * ECONOMY_MULTIPLIER * numOfTickets;
                break;
            case 2:
                totalPrice = selectedFlight.getPricePerTicket() * BUSINESS_MULTIPLIER * numOfTickets;
                break;
            case 3:
                totalPrice = selectedFlight.getPricePerTicket() * FIRST_CLASS_MULTIPLIER * numOfTickets;
                break;
        }
        return totalPrice;
    }

    public void printReceipt(int flightId, int numOfTickets, int flightClass) {
        Flight selectedFlight = availableFlights[flightId - 1];
        double totalPrice = calculateTotalPrice(flightId, numOfTickets, flightClass);
        System.out.println("\n=== RECEIPT ===");
        System.out.println("Flight: " + selectedFlight.getFlightDetails());
        System.out.println("Number of Tickets: " + numOfTickets);
        System.out.println("Total Price: $" + totalPrice);
    }

    public void displayAvailableClasses() {
        System.out.println("\nAvailable Classes:");
        System.out.println("1. Economy Class");
        System.out.println("2. Business Class");
        System.out.println("3. First Class");
    }
}
