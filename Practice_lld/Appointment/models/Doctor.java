package Appointment.models;
import java.util.*;
public class Doctor {
    private String id;
    private String name;
    private Map<String, Boolean> availability;
    private String specialization;
    public Doctor(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = new HashMap<>();
    }
    public Boolean getAvailability(String timeSlot) {
        if(!availability.containsKey(timeSlot)) {
            availability.put(timeSlot, true);
        }
        return false;
    }
    public void setAvailability(String timeSlot, Boolean isAvailable) {
        availability.put(timeSlot, isAvailable);
    }
    public String getId() {
        return id;
    }
}
