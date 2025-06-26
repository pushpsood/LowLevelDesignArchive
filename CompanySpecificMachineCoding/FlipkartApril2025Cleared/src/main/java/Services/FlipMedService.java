package Services;

import Constants.Speciality;
import Model.Appointment;
import Model.Doctor;
import Model.Patient;
import Model.Slot;
import SlotSortingStratergy.SortingContext;
import SlotSortingStratergy.TimeBasedSorting;
import Util.SlotUtil;

import java.util.*;

public class FlipMedService {
    private final SlotUtil slotUtil= new SlotUtil();
    private static FlipMedService instance;
    private Map<String, Doctor> doctors = new HashMap<>();
    private Map<String, Patient> patients = new HashMap<>();
    private List<Slot> freeSlots = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private Map<Speciality, List<Slot>> availableSlots = new HashMap<>();
    private int bookingId = 1;
    private SortingContext sortingContext = new SortingContext();

    private FlipMedService() {
    }

    public static FlipMedService getInstance() {
        if (instance == null) {
            instance = new FlipMedService();
        }
        return instance;
    }

    public void registerDoctor(String name, Speciality speciality) {
        if (doctors.containsKey(name)) {
            System.out.println("Doctor " + name + " already exists.");
            return;
        }
        Doctor doctor = new Doctor(name, speciality);
        doctors.put(name, doctor);
        availableSlots.putIfAbsent(speciality, new ArrayList<>());
        System.out.println("Welcome Dr. " + name + "!!");
    }

    public void markDoctorAvailability(String doctorName, List<String> slotTimes) {
        Doctor doctor = doctors.get(doctorName);
        if (doctor == null) {
            System.out.println("Doctor " + doctorName + " does not exist.");
            return;
        }

        // Patient A want Dr B appointment for Speciality C
        // Cretare appointment for DR b forr any timeslot

        for (String time : slotTimes) {
            int startTime = slotUtil.getStartTime(time);
            if(freeSlots.stream().anyMatch(slot -> slot.getStartTime() == startTime
                    && slot.getDoctor() != null && slot.getDoctor().getName().equals(doctorName))) {
                System.out.println("Slot " + startTime + ":00 already exists for Dr. " + doctorName);
                continue;
            }
            Slot newSlot = new Slot(startTime);
            newSlot.setDoctor(doctor);
            freeSlots.add(newSlot);
            availableSlots.computeIfAbsent(doctor.getSpeciality(), k -> new ArrayList<>()).add(newSlot);
        }

        sortingContext.setStrategy(new TimeBasedSorting());
        sortingContext.sortSlots(availableSlots.get(doctor.getSpeciality()));
        System.out.println("Done Doc!");
    }

    public void bookAppointment(String patientName, String doctorName, String timeSlot) {
        Patient patient = patients.get(patientName);
        Doctor doctor = doctors.get(doctorName);
        if (patient == null || doctor == null) {
            System.out.println("Invalid patient or doctor name.");
            return;
        }

        int startTime = slotUtil.getStartTime(timeSlot);

        if (patient.getBookedSlots().contains(startTime)) {
            System.out.println("Patient " + patientName + " already has an appointment at " + startTime + ":00");
            return;
        }

        boolean slotFound = false;
        for (Slot slot : freeSlots) {
            if (slot.getStartTime() == startTime &&
                    slot.getDoctor() != null &&
                    slot.getDoctor().getName().equals(doctorName) &&
                    slot.getPatient() == null) {

                slot.setPatient(patient);
                patient.addSlot(startTime);
                appointments.add(new Appointment(slot, patient, bookingId));
                freeSlots.remove(slot);
                System.out.println("Booked. Booking id: " + bookingId++);
                slotFound = true;
                break;
            }
        }

        if (!slotFound) {
            System.out.println("No available slots with Dr. " + doctorName + " at " + startTime + ":00");
        }
    }


    public void showAppointmentsBooked(String name) {
        boolean found = false;
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getName().equals(name) || appointment.getSlot().getDoctor().getName().equals(name)) {
                System.out.println(appointment);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for " + name);
        }
    }

    public void registerPatient(String name) {
        if (patients.containsKey(name)) {
            System.out.println("Patient " + name + " already exists.");
            return;
        }
        patients.put(name, new Patient(name));
        System.out.println(name + " registered successfully.");
    }




    public void cancelBooking(int bookingId) {
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getBookingId() == bookingId) {
                appointment.getSlot().setPatient(null);
                freeSlots.add(appointment.getSlot());
                appointment.getPatient().getBookedSlots().remove(appointment.getSlot().getStartTime());
                iterator.remove();
                System.out.println("Booking Cancelled");
                return;
            }
        }
        System.out.println("Booking id " + bookingId + " not found.");
    }
}

