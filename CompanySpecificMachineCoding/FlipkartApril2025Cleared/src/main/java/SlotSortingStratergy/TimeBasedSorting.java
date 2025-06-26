package SlotSortingStratergy;

import Model.Slot;

import java.util.Comparator;
import java.util.List;

public class TimeBasedSorting implements SlotSortingStrategy {
    @Override
    public void sort(List<Slot> slots) {
        slots.sort(Comparator.comparingInt(s -> s.getStartTime()));
    }
}
