package Google_Calendar;
import java.util.ArrayList;
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

        List<String> inviteeIds = new ArrayList<>(); // List of invitee IDs
        inviteeIds.add("user2");
        inviteeIds.add("user3");
        // Create an event
        Event event = new Event("event1", "Meeting", "Project discussion", 1672537600L, 1672541400L, "Conference Room", "user1", inviteeIds);     
        
        // Book the event
        String bookingResult = calendarService.bookEvent("user1", event);
        System.out.println(bookingResult);


        // Get user events
        calendarService.getUserEvents("user1");
        System.out.println();
        for (String userId : inviteeIds) {
            calendarService.getUserEvents(userId);
            System.out.println();
        }

        // not conflicting event for event1 for user2 and user3 so lets chaneg the start and end time of event1 to be  not conflicting with event for user2 and user3
        List<String> inviteeIds2 = new ArrayList<>(); // List of invitee IDs
        inviteeIds2.add("user2");
        inviteeIds2.add("user3");
        Event event1 = new Event("event1-followup", "Meeting 1", "Project discussion 1", 1672541400L, 1672545000L, "Conference Room", "user1", inviteeIds2);
        String bookingResult1 = calendarService.bookEvent("user1", event1);
        System.out.println(bookingResult1);
        calendarService.getUserEvents("user1");
        System.out.println();
        for (String userId : inviteeIds) {
            calendarService.getUserEvents(userId);
            System.out.println();   
        }

    
        // cancel event1-followup
        Event canceledEvent = calendarService.cancelEvent("event1");
        if (canceledEvent != null) {
            System.out.println("Event " + canceledEvent.getId() + " canceled successfully.");
        } else {
            System.out.println("Event cancellation failed.");           
        }

        List<String> inviteeIds3 = new ArrayList<>(); // List of invitee IDs
        inviteeIds3.add("user1");
        inviteeIds3.add("user3");
        Event event2 = new Event("event2", "Meeting 2", "Project discussion 2", 1672537600L, 1672541400L, "Conference Room", "user2", inviteeIds3);
        String bookingResult2 = calendarService.bookEvent("user2", event2);
        System.out.println(bookingResult2);

        calendarService.getUserEvents("user2");
        System.out.println();

        for (String userId : inviteeIds) {
            calendarService.getUserEvents(userId);
            System.out.println();   
        }


    }

}
