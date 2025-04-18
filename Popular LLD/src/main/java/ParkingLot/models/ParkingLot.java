package ParkingLot.models;

import ParkingLot.models.slots.ParkingSlot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Integer floors;

    private final List<ParkingFloor> parkingFloorList;
    private final Map<Integer, EntranceGate> entranceGateMap;
    private final Map<Integer, ExitGate> exitGateMap;

    private final Map<String, Ticket> parkingTicketMap;

    public ParkingLot(Integer floors, List<ParkingFloor> parkingFloorList,
                      Map<Integer, EntranceGate> entranceGateMap, Map<Integer, ExitGate> exitGateMap) {
        this.floors = floors;
        this.parkingFloorList = parkingFloorList;
        this.entranceGateMap = entranceGateMap;
        this.exitGateMap = exitGateMap;
        this.parkingTicketMap = new HashMap<>();
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloorList.add(floor);
    }

    public void addEntranceGate(EntranceGate entranceGate) {
        entranceGateMap.put(entranceGateMap.size()+1, entranceGate);
    }

    public void addExitGate(ExitGate exitGate) {
        exitGateMap.put(exitGateMap.size()+1, exitGate);
    }

    //Finding parking space for vehicle type, generate ticket and park the car
    public void findParkingSpaceAndPark(Integer entrancePoint, Vehicle vehicle) {
        parkingFloorList.forEach(parkingFloor -> {
            ParkingSlot parkingSlot = parkingFloor.getAvailableSpot(vehicle);
            if (parkingSlot != null) {
                EntranceGate entranceGate = entranceGateMap.get(entrancePoint);
                System.out.println("Vehicle Entrance made by Gate :" + entranceGate.getEntranceNumber());
                Ticket ticket = entranceGate.generateTicket(vehicle, parkingSlot.getParkingSlotId(), parkingFloor.getFloorId());
                System.out.println("Ticket Generated for Vehicle :" + vehicle.getRegistrationNumber());
                Boolean isParked = parkingFloor.parkVehicleIntoSlot(vehicle);
                if (isParked) {
                    parkingTicketMap.put(vehicle.getRegistrationNumber(), ticket);
                    System.out.println("Vehicle has been parked in parking floor " + parkingFloor.getFloorId());
                } else {
                    System.out.println("Capacity full for Vehicle Type : " + vehicle.getVehicleType());
                }
            } else {
                System.out.println("No Slot Available for vehicle type " + vehicle.getVehicleType());
            }
        });
    }

    //Unfree parking spot when car leaves
    public void unfreeSpace(Integer exitPoint, String registrationNumber) {
        parkingFloorList.forEach(parkingfloor -> {
            Ticket ticket = parkingTicketMap.get(registrationNumber);
            if (ticket != null) {
                Vehicle vehicle = ticket.getVehicle();
                if (parkingfloor.isVehiclePresent(vehicle)) {
                    ExitGate exitGate = exitGateMap.get(exitPoint);
                    exitGate.paymentProcessing(ticket);
                    System.out.println("Payment has been made for Vehicle : " + registrationNumber);
                    parkingfloor.unparkVehicleFromSlot(vehicle);
                    parkingTicketMap.remove(vehicle.getRegistrationNumber());
                    System.out.println("Vehicle has been unparked from parking floor " + ticket.getFloorId());
                } else {
                    System.out.println("Vehicle with registration number " + vehicle.getRegistrationNumber() + " not present in parking lot");
                }
            } else {
                System.out.println("Vehicle with ticket number " + registrationNumber + " not present in parking lot");
            }
        });
    }

}
