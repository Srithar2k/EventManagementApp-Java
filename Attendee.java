public class Attendee {
    private String attendeeId;
    private String name;
    private String email;
    private String ticketType;
    private boolean checkInStatus;
    private static int attendeeCounter = 1;

    public Attendee(String name, String email, String ticketType) {
        this.attendeeId = "A" + attendeeCounter++;
        this.name = name;
        this.email = email;
        this.ticketType = ticketType;
        this.checkInStatus = false;
    }

    // Getters and Setters
    public String getAttendeeId() { return attendeeId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getTicketType() { return ticketType; }
    public boolean isCheckInStatus() { return checkInStatus; }
    public void setCheckInStatus(boolean checkInStatus) { this.checkInStatus = checkInStatus; }
}