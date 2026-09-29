package Google_Calendar;
import java.util.List;
import Google_Calendar.BookingStrategy.BookingStrategy;
import Google_Calendar.models.Event;
import Google_Calendar.models.User;
import Google_Calendar.repository.UserRepo;
import Google_Calendar.service.CalenderService;
import Google_Calendar.BookingStrategy.AllAvailable;

public class Main {
    public static void main(String[] args) {
        BookingStrategy bookingStrategy = new AllAvailable();
        CalenderService calendarService = new CalenderService(bookingStrategy);

        // Create users
        UserRepo userRepo = new UserRepo();
        userRepo.addUser(new User("user1", "San2", "san2@example.com"));
        userRepo.addUser(new User("user2", "User 2", "user2@example.com"));  
        userRepo.addUser(new User("user3", "User 3", "user3@example.com"));  

        List<String> inviteeIds = List.of("user2", "user3", "user1"); // List of invitee IDs
        // Create an event
        Event event = new Event("event1", "Meeting", "Project discussion", 1672537600L, 1672541400L, "Conference Room", "user1", inviteeIds);     
        
        // Book the event
        String bookingResult = calendarService.bookEvent("user1", event);
        System.out.println(bookingResult);


        // Get user events
        for (String userId : inviteeIds) {
            calendarService.getUserEvents(userId);
            System.out.println();
        }

        Event event2 = new Event("event2", "Meeting 2", "Project discussion 2", 1672537600L, 1672541400L, "Conference Room", "user1", inviteeIds);
        String bookingResult2 = calendarService.bookEvent("user1", event2);
        System.out.println(bookingResult2);
        for (String userId : inviteeIds) {
            calendarService.getUserEvents(userId);
            System.out.println();   
        }

    }

}
