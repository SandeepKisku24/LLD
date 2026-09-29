package Google_Calendar.BookingStrategy;
import Google_Calendar.models.Event;
import Google_Calendar.repository.UserRepo;
 
public interface BookingStrategy {
    boolean canBook(Event event, UserRepo userRepo);
    public String bookEvent(Event event, UserRepo userRepo);
}
