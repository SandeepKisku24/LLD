package Appointment.repositories;

import java.util.*;
import Appointment.models.Booking;
import Appointment.models.Doctor;
import Appointment.models.Patient;
public class BookingRepo {
    // time to bookings
    private Map<String, Booking> bookingMap;
    private Map<String, Queue<Patient>> waitingListMap; // time_doctorId to patientId
    public BookingRepo() {
        this.bookingMap = new HashMap<>();
        this.waitingListMap = new HashMap<>();
    }   

    public void book(Booking booking) {
        bookingMap.put(booking.getId(), booking);
    }
    public List<Booking> getDoctorBooking(String id) {
        List<Booking> doctorBookings = new ArrayList<>();
        for(Booking booking : bookingMap.values()) {
            if(booking.getDoctor().getId().equals(id)) {
                doctorBookings.add(booking);
            }
        }
        return doctorBookings;
    }

    public void addToWaitingList(String timeSlot, String doctorId, Patient patient) {
        String key = timeSlot + "-" + doctorId;
        waitingListMap.putIfAbsent(key, new LinkedList<>());
        waitingListMap.get(key).add(patient);
    }

    
}
