package Google_Calendar.service;
import java.util.List;
import java.sql.Time;
import Google_Calendar.repository.EventRepo;
import Google_Calendar.repository.UserRepo;
import Google_Calendar.models.Event;
import Google_Calendar.models.User;
import Google_Calendar.BookingStrategy.BookingStrategy;
public class CalenderService {
    public EventRepo eventRepo;
    public UserRepo userRepo;
    public BookingStrategy bookingStrategy;
    public CalenderService(BookingStrategy bookingStrategy) {
        eventRepo = new EventRepo();
        userRepo = new UserRepo();
        this.bookingStrategy = bookingStrategy;
    }
    public String addUsers(String userId, User user) {
        return userRepo.addUser(user);
    }

    public String addEvent(String userId, Event event) {
        String eventId = eventRepo.addEvent(event);
        userRepo.addEventToUser(userId, event);
        return eventId;
    }
    public Event cancelEvent(String eventId) {
        return eventRepo.cancelEvent(eventId);
    }


    // logic to create a new event and add it to the user's calendar
    // check if the current time is before the event's start time,if yes create the event
    public String bookEvent(String userId, Event event) {
        if (bookingStrategy.canBook(event, userRepo)) {
            eventRepo.addEvent(event);
            userRepo.addEventToUser(userId, event);
            return bookingStrategy.bookEvent(event, userRepo);
        } else {
            return "One or more invitees are not available for the event time slot. Event booking failed.";
        }
    }

    public void getUserEvents(String userId) {
        // logic to get all events for a user
        List<Event> events = userRepo.getUserEvents(userId);
        System.out.println("Events for user " + userId + ":");
        for (Event event : events) {
            Time startTime = new Time(event.getStartTime());
            Time endTime = new Time(event.getEndTime());
            System.out.println(event.getTitle() + " from " + startTime + " to " + endTime  + " organized by " + event.getSenderId());
        }
    }
}
