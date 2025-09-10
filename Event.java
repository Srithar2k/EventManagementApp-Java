import java.time.LocalDate;

public class Event {
    private String eventId;
    private String name;
    private LocalDate date;
    private String venue;
    private int capacity;
    private static int eventCounter = 1;

    public Event(String name, LocalDate date, String venue, int capacity) {
        this.eventId = "E" + eventCounter++;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getEventId() { return eventId; }
    public String getName() { return name; }
    public LocalDate getDate() { return date; }
    public String getVenue() { return venue; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}