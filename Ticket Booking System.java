4.3.A Java program to simulate a ticket booking system where VIP tickets are processed first using thread priorities.
class TicketBookingSystem {
    private int availableSeats = 5;

    public synchronized void bookTicket(String user, int seats) {
        if (availableSeats >= seats) {
            System.out.println(user + " booked " + seats + " seat(s).");
            availableSeats -= seats;
        } else {
            System.out.println(user + " booking failed. Not enough seats available.");
        }
    }
}

class BookingThread extends Thread {
    TicketBookingSystem system;
    String user;
    int seats;

    BookingThread(TicketBookingSystem system, String user, int seats, int priority) {
        this.system = system;
        this.user = user;
        this.seats = seats;
        this.setPriority(priority);
    }

    public void run() {
        system.bookTicket(user, seats);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        BookingThread user1 = new BookingThread(system, "VIP User", 2, Thread.MAX_PRIORITY);
        BookingThread user2 = new BookingThread(system, "Regular User 1", 1, Thread.NORM_PRIORITY);
        BookingThread user3 = new BookingThread(system, "Regular User 2", 2, Thread.NORM_PRIORITY);
        BookingThread user4 = new BookingThread(system, "Regular User 3", 1, Thread.MIN_PRIORITY);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}

