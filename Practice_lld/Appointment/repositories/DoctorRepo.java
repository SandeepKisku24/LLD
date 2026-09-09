package Appointment.repositories;
import java.util.*;
import Appointment.models.Doctor;
public class DoctorRepo {
    private Map<String, Doctor> doctorMap;
    public DoctorRepo() {
        this.doctorMap = new HashMap<>();
    }
    public void registerDoctor(Doctor doctor) {
        doctorMap.put(doctor.getId(), doctor);
    }
    public Doctor getDoctor(String id) {
        return doctorMap.get(id);
    }
    public List<Doctor> getAvailableDoctors(String timeSlot) {
        List<Doctor> availableDoctors = new ArrayList<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getAvailability(timeSlot)) {
                availableDoctors.add(doctor);
            }
        }
        return availableDoctors;
    }

}
