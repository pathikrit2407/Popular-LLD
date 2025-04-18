package ParkingLot.models.slots;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.models.Vehicle;

public class ParkingSlot {

    private String parkingSlotId;

    private ParkingSlotType parkingSlotType;

    private Boolean isFree;

    private Vehicle vehicle;

    public ParkingSlot(ParkingSlotType parkingSlotType, Vehicle vehicle, Boolean isFree) {
        this.parkingSlotType = parkingSlotType;
        this.vehicle = vehicle;
        this.isFree = isFree;
    }

    public String getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

}

