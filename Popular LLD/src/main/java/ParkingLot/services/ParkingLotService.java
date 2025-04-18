package ParkingLot.services;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.Vehicle;

public class ParkingLotService {

    private ParkingLot parkingLot;

    public ParkingLotService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void parkVehicle(Vehicle vehicle, Integer entrancePoint) {
        parkingLot.findParkingSpaceAndPark(entrancePoint, vehicle);
    }

    public void unparkVehicle(String ticketNumber, Integer exitPoint) {
        parkingLot.unfreeSpace(exitPoint, ticketNumber);
    }

    //TODO: can add functions for showing Free Slots, Occupied Slots
}
