public abstract class Ticket {
    protected String ticketId;
    protected String eventId;
    protected String type; // Regular or VIP
    protected String attendeeId;
    protected double price;
    protected String state; // Available, Sold, Used
    private static int ticketCounter = 1;

    public Ticket(String eventId, String type) {
        this.ticketId = "T" + ticketCounter++;
        this.eventId = eventId;
        this.type = type;
        this.state = "Available";
    }

    public abstract double getPrice(); // Method overriding
    public abstract String printBadge(); // Method overriding

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public String getEventId() { return eventId; }
    public String getType() { return type; }
    public String getAttendeeId() { return attendeeId; }
    public double getPriceValue() { return price; }
    public String getState() { return state; }
    public void setAttendeeId(String attendeeId) { this.attendeeId = attendeeId; }
    public void setState(String state) { this.state = state; }
}

class RegularTicket extends Ticket {
    public RegularTicket(String eventId) {
        super(eventId, "Regular");
        this.price = 50.0;
    }

    @Override
    public double getPrice() { return this.price; }

    @Override
    public String printBadge() {
        return "Regular Attendee Badge\nTicket ID: " + this.ticketId;
    }
}

class VIPTicket extends Ticket {
    public VIPTicket(String eventId) {
        super(eventId, "VIP");
        this.price = 150.0;
    }

    @Override
    public double getPrice() { return this.price; }

    @Override
    public String printBadge() {
        return "VIP Attendee Badge\nTicket ID: " + this.ticketId + "\nAccess: All Areas";
    }
}