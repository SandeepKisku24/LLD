package Google_Calendar.repository;
import java.util.*;
import Google_Calendar.models.User;
import Google_Calendar.models.Event;
public class UserRepo {
    HashMap<String, User> UserMap = new HashMap<>();
    HashMap<String, Event> UserEventsMap = new HashMap<>();
    public String addUser(User user) {
        UserMap.put(user.getId(), user);
        return user.getId();
    }
    public void addEventToUser(String userId, Event event) {
        UserEventsMap.put(userId, event);
    }
    public boolean isUserAvailable(String userId, Long startTime, Long endTime) {
        // logic to check if user is available for the given time slot
        Event event = UserEventsMap.get(userId);
        if (event == null) {
            return true;
        }
        return !(startTime < event.getEndTime() && endTime > event.getStartTime());
    }

    public List<Event> getUserEvents(String userId) {
        // logic to get all events for a user
        List<Event> events = new ArrayList<>();
        for (Event event : UserEventsMap.values()) {
            if (event.getSenderId().equals(userId) || event.getInviteeIds().contains(userId)) {
                events.add(event);
            }
        }
        return events;
    }

}
