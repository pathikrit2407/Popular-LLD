package ParkingLot.models;

import java.time.LocalDate;

public class Ticket {

    private LocalDate entryTime;

    private Vehicle vehicle;

    private String parkingSlotId;

    private Integer entranceNumber;

    private String floorId;

    public Ticket(LocalDate entryTime, Vehicle vehicle, String parkingSlotId, String floorId) {
        this.entryTime =entryTime;
        this.vehicle =vehicle;
        this.parkingSlotId = parkingSlotId;
        this.floorId = floorId;
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

    public LocalDate getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDate entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getEntranceNumber() {
        return entranceNumber;
    }

    public void setEntranceNumber(Integer entranceNumber) {
        this.entranceNumber = entranceNumber;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }
}
