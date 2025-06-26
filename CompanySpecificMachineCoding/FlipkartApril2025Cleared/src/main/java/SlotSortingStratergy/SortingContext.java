package SlotSortingStratergy;

import Model.Slot;

import java.util.List;

public class SortingContext {
    private SlotSortingStrategy strategy;

    public void setStrategy(SlotSortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortSlots(List<Slot> slots) {
        if (strategy != null) {
            strategy.sort(slots);
        }
    }
}