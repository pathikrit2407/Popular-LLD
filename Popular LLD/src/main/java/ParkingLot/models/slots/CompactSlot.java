package ParkingLot.models.slots;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.models.Vehicle;

public class CompactSlot extends ParkingSlot {
    public CompactSlot(Vehicle vehicle, Boolean isFree) {
        super(ParkingSlotType.COMPACT, vehicle, isFree);
    }
}
