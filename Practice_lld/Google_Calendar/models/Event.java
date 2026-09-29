package Google_Calendar.models;
import java.util.List;
public class Event {
    private String id;
    private String title;
    private String description;
    private Long startTime;
    private Long endTime;
    private String location;
    private String senderId;
    private List<String> inviteeIds;

    public Event(String id, String title, String description, Long startTime, Long endTime, String location, String senderId, List<String> inviteeIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.senderId = senderId;
        this.inviteeIds = inviteeIds;
    }

    public String getId() {
        return id;
    }
    public List<String> getInviteeIds() {
        return inviteeIds;
    }
    public String getSenderId() {
        return senderId;
    }   
    public Long getEndTime() {
        return endTime;
    }
    public Long getStartTime() {
        return startTime;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

}
