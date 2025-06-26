package Util;

import Exception.InvalidSlotsException;

public class SlotUtil {
    public int getStartTime(String time) {
        // "9:00-10:00"
        String[] parts = time.split("-");
        try {
            String[] startParts = parts[0].split(":");
            String[] endParts = parts[1].split(":");
            int startTime = Integer.parseInt(startParts[0]);
            int endTime = Integer.parseInt(endParts[0]);

            if (startParts.length > 1 && Integer.parseInt(startParts[1]) != 0) {
                throw new InvalidSlotsException("Invalid time format.");
            }
            if (endParts.length > 1 && Integer.parseInt(endParts[1]) != 0) {
                throw new InvalidSlotsException("Invalid time format.");
            }

            if (startTime < 9 || endTime > 21) {
                System.out.println("Slots must be between 9:00 and 21:00.");
                throw new InvalidSlotsException("Invalid time format.");
            }
            if (endTime - startTime != 1) {
                System.out.println("slots are 60 mins only");
                throw new InvalidSlotsException("Invalid time format.");
            }

            return startTime;
        } catch (InvalidSlotsException e) {
            System.out.println("Invalid time format." + e);
            throw new InvalidSlotsException("Invalid time format.");
        }

    }
}
