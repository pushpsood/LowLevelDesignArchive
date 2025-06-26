import Constants.Speciality;
import Services.FlipMedService;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        FlipMedService flipmed = FlipMedService.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Register Doctor");
            System.out.println("2. Mark Doctor Availability");
            System.out.println("3. Register Patient");
            System.out.println("4. Book Appointment");
            System.out.println("5. Show Appointments");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Speciality (CARDIOLOGIST, DERMATOLOGIST, ORTHOPEDIC, GENERAL_PHYSICIAN): ");
                    Speciality speciality = Speciality.valueOf(scanner.nextLine().toUpperCase());
                    flipmed.registerDoctor(doctorName, speciality);
                    break;

                case 2:
                    System.out.print("Enter Doctor Name: ");
                    String doctorForAvailability = scanner.nextLine();
                    System.out.print("Enter Availability Slots (comma-separated, e.g., 9:00-10:00,12:00-13:00): ");
                    String[] slots = scanner.nextLine().split(",");
                    flipmed.markDoctorAvailability(doctorForAvailability, Arrays.asList(slots));
                    break;

                case 3:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    flipmed.registerPatient(patientName);
                    break;

                case 4:
                    System.out.print("Enter Patient Name: ");
                    String patientForBooking = scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctorForBooking = scanner.nextLine();
                    System.out.print("Enter Slot: ");
                    String slot = scanner.nextLine();
                    flipmed.bookAppointment(patientForBooking, doctorForBooking, slot);
                    break;

                case 5:
                    System.out.print("Enter Doctor Name: ");
                    String doctorForAppointments = scanner.nextLine();
                    flipmed.showAppointmentsBooked(doctorForAppointments);
                    break;

                case 6:
                    System.out.print("Enter Booking ID to Cancel: ");
                    int bookingId = scanner.nextInt();
                    flipmed.cancelBooking(bookingId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}