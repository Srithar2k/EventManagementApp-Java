import java.time.LocalDate;

public class EventAppMain {
    public static void main(String[] args) {
        EventService eventService = new EventService();

        // 1. Create an event
        Event techConference = new Event("Tech Innovations 2024", LocalDate.of(2024, 10, 25), "Convention Center", 100);
        eventService.createEvent(techConference);
        String eventId = techConference.getEventId();

        System.out.println("\n--- Generating Tickets ---");
        // 2. Generate and allocate tickets
        eventService.generateTickets(eventId, 5, 2);

        System.out.println("\n--- Selling/Allocating Tickets & Capturing RSVPs ---");
        // Method Overloading demonstrated here: rsvp(name, email, ticketId)
        eventService.rsvp("John Doe", "john.doe@email.com", "T1");
        eventService.rsvp("Jane Smith", "jane.smith@email.com", "T2");
        eventService.rsvp("Alice Johnson", "alice.j@email.com", "T6"); // VIP ticket

        System.out.println("\n--- Handling Check-ins ---");
        // Encapsulation of check-in logic and state transition
        eventService.checkIn("T1"); // John Doe checks in
        eventService.checkIn("T2"); // Jane Smith checks in
        eventService.checkIn("T6"); // Alice Johnson checks in

        // Invalid check-in attempts
        eventService.checkIn("T1"); // Already checked in
        eventService.checkIn("T5"); // Ticket not sold/used yet

        System.out.println("\n--- Printing Attendee List ---");
        eventService.printAttendeeList(eventId);

        System.out.println("\n--- Calculating Revenue (Polymorphism) ---");
        double revenue = eventService.calculateRevenue(eventId);
        System.out.printf("Total revenue for %s: $%.2f\n", techConference.getName(), revenue);

        // Demonstrating method overriding for badges
        // (This would be part of the ticket object, not the service, but we can call it here for demo)
        Ticket vipTicket = new VIPTicket(eventId);
        Ticket regularTicket = new RegularTicket(eventId);
        System.out.println("\n--- Demonstrating Method Overriding for Badges ---");
        System.out.println(vipTicket.printBadge());
        System.out.println("-----------------");
        System.out.println(regularTicket.printBadge());
    }
}