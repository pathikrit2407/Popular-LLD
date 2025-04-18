package ParkingLot.models.slots;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.models.Vehicle;

public class HandicappedSlot extends ParkingSlot {
    public HandicappedSlot(Vehicle vehicle, Boolean isFree) {
        super(ParkingSlotType.HANDICAPPED, vehicle, isFree);
    }
}
