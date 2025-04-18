package ParkingLot.models;

import ParkingLot.enums.VehicleType;

public class Vehicle {

    private String registrationNumber;
    private VehicleType vehicleType;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
}
