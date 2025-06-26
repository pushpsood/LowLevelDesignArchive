package Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {
    private int startTime;
    private Doctor doctor;
    private Patient patient;

    public Slot(int startTime) {
        this.startTime = startTime;
    }

    // Getters and setters
    public int getStartTime() {
        return startTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
