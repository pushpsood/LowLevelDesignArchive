package Model;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
public class Patient {
    @Getter
    private String name;
    @Getter
    Set<Integer> bookedSlots = new HashSet<>();
    public Patient(String name) {
        this.name = name;
    }

    public void addSlot(int slot) {
        bookedSlots.add(slot);
    }
}
