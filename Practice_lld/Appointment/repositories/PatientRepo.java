package Appointment.repositories;

import java.util.*;
import Appointment.models.Patient;
public class PatientRepo {
    private Map<String, Patient> patientMap;
    public PatientRepo() {
        this.patientMap = new HashMap<>();
    }   

    public void registerPatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
    }

}
