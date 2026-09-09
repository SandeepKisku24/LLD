package Appointment.models;
import Appointment.enums.*;

public class Booking {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private String timeSlot;
    private Status status;
    private Double amount;

    public Booking(String id, Doctor doctor, Patient patient, String timeSlot) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.status = status.PENDING;
        this.amount = 0.0;
    }
    
    public String getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public Status getStatus() {
        return status;
    }
}
