package SlotSortingStratergy;

import Model.Slot;

import java.util.Comparator;
import java.util.List;

public class RatingBasedSorting implements SlotSortingStrategy {
    @Override
    public void sort(List<Slot> slots) {
        //Default as of now
        slots.sort(Comparator.comparingInt(s -> s.getStartTime()));
    }
}
