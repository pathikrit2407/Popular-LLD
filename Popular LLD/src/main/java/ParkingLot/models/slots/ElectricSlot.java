package ParkingLot.models.slots;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.models.Vehicle;

public class ElectricSlot extends ParkingSlot {
    public ElectricSlot(Vehicle vehicle, Boolean isFree) {
        super(ParkingSlotType.ELECTRIC, vehicle, isFree);
    }
}
