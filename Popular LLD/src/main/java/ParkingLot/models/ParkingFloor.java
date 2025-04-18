package ParkingLot.models;

import ParkingLot.enums.ParkingSlotType;
import ParkingLot.enums.VehicleType;
import ParkingLot.exceptions.NoSlotException;
import ParkingLot.models.slots.*;

import java.util.List;
import java.util.Map;

import static ParkingLot.enums.ParkingSlotType.*;

public class ParkingFloor {

    private String floorId;

    private final Map<ParkingSlotType, List<ParkingSlot>> parkingSpots;

    public ParkingFloor(String floorId, Map<ParkingSlotType, List<ParkingSlot>> parkingSpots) {
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    //Available Spots for Vehicle
    public ParkingSlot getAvailableSpot(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingSlotType parkingSlotType = getParkingSlotTypeBasedOnVehicle(vehicleType);

        for(ParkingSlot parkingSlot: parkingSpots.get(parkingSlotType)) {
            if (parkingSlot.getFree()) return parkingSlot;
        }

        //no available parking spot
        return null;
    }

    //get Parking slot type based on vehicle
    ParkingSlotType getParkingSlotTypeBasedOnVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
            case VAN:
                return COMPACT;
            case TRUCK:
                return LARGE;
            case MOTORBIKE:
                return MOTORBIKE;
            case ELECTRIC:
                return ELECTRIC;
        }

        throw new NoSlotException("No Slot Type Available for the vehicle type");
    }

    //park vehicle into the parking spot of the parking floor
    public Boolean parkVehicleIntoSlot(Vehicle vehicle) {
        ParkingSlotType parkingSlotType = getParkingSlotTypeBasedOnVehicle(vehicle.getVehicleType());
        List<ParkingSlot> parkingSlots = parkingSpots.get(parkingSlotType);

        for (ParkingSlot parkingSlot : parkingSlots) {
            if (parkingSlot.getFree()) {
                parkingSlot.setVehicle(vehicle);
                parkingSlot.setFree(false);
                return true;
            }
        }
        return false;
    }

    //unpark vehicle from the parking spot
    public Boolean unparkVehicleFromSlot(Vehicle vehicle) {
        ParkingSlotType parkingSlotType = getParkingSlotTypeBasedOnVehicle(vehicle.getVehicleType());
        List<ParkingSlot> parkingSlots = parkingSpots.get(parkingSlotType);

        for(ParkingSlot parkingSlot : parkingSlots) {
            if (!parkingSlot.getFree() && parkingSlot.getVehicle().equals(vehicle)) {
                parkingSlot.setVehicle(null);
                parkingSlot.setFree(true);
                return true;
            }
        }

        return false;
    }

    //Find Vehicle in the Parking floor
    public Boolean isVehiclePresent(Vehicle vehicle) {
        List<ParkingSlot> parkingSlots = parkingSpots.get(getParkingSlotTypeBasedOnVehicle(vehicle.getVehicleType()));
        for (ParkingSlot parkingSlot: parkingSlots) {
            if (!parkingSlot.getFree() && parkingSlot.getVehicle().equals(vehicle)) {
                return true;
            }
        }

        return false;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    //TODO: Add parking display board class

    /*
    FUNCTIONALITIES -
    1. showing the details of free parking spots available
     */

}
