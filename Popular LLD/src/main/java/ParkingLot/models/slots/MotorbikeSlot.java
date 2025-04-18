package ParkingLot.models.slots;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.models.Vehicle;

public class MotorbikeSlot extends ParkingSlot {
    public MotorbikeSlot(Vehicle vehicle, Boolean isFree) {
        super(ParkingSlotType.MOTORBIKE, vehicle, isFree);
    }
}
