package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Appointment {
    private Slot slot;
    private Patient patient;
    int bookingId;
}
