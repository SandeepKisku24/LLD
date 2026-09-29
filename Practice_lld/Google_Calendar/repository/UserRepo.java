package Google_Calendar.repository;
import java.util.*;
import Google_Calendar.models.User;
import Google_Calendar.models.Event;
public class UserRepo {
    HashMap<String, User> UserMap = new HashMap<>();
    HashMap<String, List<Event>> UserEventsMap = new HashMap<>();
    public String addUser(User user) {
        UserMap.put(user.getId(), user);
        return user.getId();
    }
    public void addEventToUser(String userId, Event event) {
        UserEventsMap.put(userId, UserEventsMap.getOrDefault(userId, new ArrayList<>()));
        UserEventsMap.get(userId).add(event);
    }
    public boolean isUserAvailable(String userId, Long startTime, Long endTime) {
        // logic to check if user is available for the given time slot
        List<Event> events = UserEventsMap.get(userId);
        if (events == null) {
            return true;
        }
        for (Event event : events) {
            if (startTime < event.getEndTime() && endTime > event.getStartTime()) {
                return false;
            }
        }
        return true;
    }

    public List<Event> getUserEvents(String userId) {
        // logic to get all events for a user
        List<Event> events = new ArrayList<>();
        for (Event event : UserEventsMap.getOrDefault(userId, new ArrayList<>())) {
            if (event.getSenderId().equals(userId) || event.getInviteeIds().contains(userId)) {
                events.add(event);
            }
        }
        return events;
    }

    public void removeEventFromUser(String userId, String eventId) {
        List<Event> events = UserEventsMap.get(userId);
        if (events != null) {
            events.removeIf(event -> event.getId().equals(eventId));
        }
    }

}
