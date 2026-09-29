package Google_Calendar.BookingStrategy;
import Google_Calendar.models.Event;
import Google_Calendar.repository.UserRepo;

public class AtLeastOneAvail implements BookingStrategy {
    @Override
    public boolean canBook(Event event, UserRepo userRepo) {
        for (String inviteeId : event.getInviteeIds()) {
            if (userRepo.isUserAvailable(inviteeId, event.getStartTime(), event.getEndTime())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String bookEvent(Event event, UserRepo userRepo) {
        return "Event booked successfully!";
    }
    
}
