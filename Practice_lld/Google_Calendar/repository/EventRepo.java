package Google_Calendar.repository;
import java.util.*;
import Google_Calendar.models.Event;
public class EventRepo {
    HashMap<String, Event> EventMap = new HashMap<>();

    public String addEvent(Event event) {
        // logic to add event to the map
        EventMap.put(event.getId(), event);
        return event.getId();   
    }
    public Event cancelEvent(String eventId) {
        // logic to cancel event
        return EventMap.remove(eventId);
    }
    public Event editEvent(String eventId, Event updatedEvent) {
        // logic to edit event
        EventMap.put(eventId, updatedEvent);
        return updatedEvent;
    }

}
