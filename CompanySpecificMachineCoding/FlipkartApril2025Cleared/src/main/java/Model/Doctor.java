package Model;

import Constants.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Doctor {
    private String name;
    private Speciality speciality;
}
