import java.util.Random;

class Theater {
    private int availableSeats;

    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
    }
    public synchronized boolean reserveSeats(int customerId, int numSeats) {
        if (numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println("Customer " + customerId + " reserved " + numSeats + " tickets.");
            return true;
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + numSeats + " tickets.");
            return false;
        }
    }
}

class Customer extends Thread {
    private int customerId;
    private int requestedSeats;
    private Theater theater;

    public Customer(int customerId, int requestedSeats, Theater theater) {
        this.customerId = customerId;
        this.requestedSeats = requestedSeats;
        this.theater = theater;
    }

    @Override
    public void run() {
        theater.reserveSeats(customerId, requestedSeats);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        Theater theater = new Theater(10);
        Random random = new Random();

        for (int i = 1; i <= 15; i++) {
            int ticketsToReserve = random.nextInt(4) + 1; 
            Customer customer = new Customer(i, ticketsToReserve, theater);
            customer.start();
        }
    }
}