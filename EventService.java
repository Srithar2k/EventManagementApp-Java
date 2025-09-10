import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventService {
    private Map<String, Event> events = new HashMap<>();
    private Map<String, Attendee> attendees = new HashMap<>();
    private Map<String, Ticket> tickets = new HashMap<>(); // Polymorphism

    public void createEvent(Event event) {
        events.put(event.getEventId(), event);
        System.out.println("Event created: " + event.getName());
    }

    public void generateTickets(String eventId, int regularCount, int vipCount) {
        if (!events.containsKey(eventId)) {
            System.out.println("Error: Event not found.");
            return;
        }
        for (int i = 0; i < regularCount; i++) {
            Ticket ticket = new RegularTicket(eventId);
            tickets.put(ticket.getTicketId(), ticket);
        }
        for (int i = 0; i < vipCount; i++) {
            Ticket ticket = new VIPTicket(eventId);
            tickets.put(ticket.getTicketId(), ticket);
        }
        System.out.println("Tickets generated for event " + events.get(eventId).getName());
    }

    // Method Overloading: RSVP by attendeeId
    public void rsvp(String attendeeId, String ticketId) {
        if (!attendees.containsKey(attendeeId) || !tickets.containsKey(ticketId)) {
            System.out.println("Error: Attendee or Ticket not found.");
            return;
        }
        Ticket ticket = tickets.get(ticketId);
        if ("Available".equals(ticket.getState())) {
            ticket.setAttendeeId(attendeeId);
            ticket.setState("Sold");
            System.out.println("RSVP confirmed for " + attendees.get(attendeeId).getName() + " with ticket " + ticketId);
        } else {
            System.out.println("Error: Ticket is not available.");
        }
    }

    // Method Overloading: RSVP by name and email
    public void rsvp(String name, String email, String ticketId) {
        Attendee attendee = new Attendee(name, email, tickets.get(ticketId).getType());
        attendees.put(attendee.getAttendeeId(), attendee);
        rsvp(attendee.getAttendeeId(), ticketId);
    }
    
    // Encapsulation: Gate check-in logic
    public void checkIn(String ticketId) {
        if (!tickets.containsKey(ticketId)) {
            System.out.println("Error: Ticket not found.");
            return;
        }
        Ticket ticket = tickets.get(ticketId);
        if ("Sold".equals(ticket.getState())) {
            ticket.setState("Used"); // State transition
            String attendeeId = ticket.getAttendeeId();
            if (attendeeId != null && attendees.containsKey(attendeeId)) {
                attendees.get(attendeeId).setCheckInStatus(true);
                System.out.println("Check-in successful for " + attendees.get(attendeeId).getName());
            } else {
                System.out.println("Error: Attendee data missing for ticket " + ticketId);
            }
        } else {
            System.out.println("Error: Invalid ticket state. Current state is " + ticket.getState());
        }
    }

    public void printAttendeeList(String eventId) {
        System.out.println("\n--- Attendee List for " + events.get(eventId).getName() + " ---");
        List<Ticket> eventTickets = tickets.values().stream()
                .filter(t -> eventId.equals(t.getEventId()) && "Used".equals(t.getState()))
                .collect(Collectors.toList());

        if (eventTickets.isEmpty()) {
            System.out.println("No attendees checked in yet.");
            return;
        }

        eventTickets.forEach(ticket -> {
            Attendee attendee = attendees.get(ticket.getAttendeeId());
            if (attendee != null) {
                System.out.printf("Name: %s, Email: %s, Ticket Type: %s, Check-in Status: %s\n",
                    attendee.getName(), attendee.getEmail(), attendee.getTicketType(), attendee.isCheckInStatus());
            }
        });
    }

    // Polymorphism: Compute revenue using a list of 'Ticket' objects
    public double calculateRevenue(String eventId) {
        return tickets.values().stream()
                .filter(t -> eventId.equals(t.getEventId()) && ("Sold".equals(t.getState()) || "Used".equals(t.getState())))
                .mapToDouble(Ticket::getPrice)
                .sum();
    }
}