package ParkingLot.models.slots;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.models.Vehicle;

public class LargeSlot extends ParkingSlot {
    public LargeSlot(Vehicle vehicle, Boolean isFree) {
        super(ParkingSlotType.LARGE, vehicle, isFree);
    }
}
