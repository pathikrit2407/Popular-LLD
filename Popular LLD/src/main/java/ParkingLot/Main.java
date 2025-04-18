package ParkingLot;

import ParkingLot.enums.CommandEnums;
import ParkingLot.enums.ParkingSlotType;
import ParkingLot.enums.VehicleType;
import ParkingLot.models.*;
import ParkingLot.models.slots.CompactSlot;
import ParkingLot.models.slots.MotorbikeSlot;
import ParkingLot.models.slots.ParkingSlot;
import ParkingLot.services.ParkingLotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Forming slots for testing
        List<ParkingSlot> carParkingSlots = new ArrayList<>();
        List<ParkingSlot> bikeParkingSlots = new ArrayList<>();

        for(int i=1;i<5;i++) {
            ParkingSlot carSlot = new CompactSlot(null, true);
            ParkingSlot bikeSlot = new MotorbikeSlot(null, true);

            carParkingSlots.add(carSlot);
            bikeParkingSlots.add(bikeSlot);
        }

        //Forming Map<ParkingSlotType, List<ParkingSlot>> for Parking floor
        Map<ParkingSlotType, List<ParkingSlot>> parkingFloorMap = new HashMap<>();

        parkingFloorMap.put(ParkingSlotType.COMPACT, carParkingSlots);
        parkingFloorMap.put(ParkingSlotType.MOTORBIKE, bikeParkingSlots);

        //Single Floor
        ParkingFloor parkingFloor = new ParkingFloor("1", parkingFloorMap);

        //Exit, Entrance Gate
        ExitGate exitGate1 = new ExitGate(1);
        ExitGate exitGate2 = new ExitGate(2);

        Map<Integer, ExitGate> exitGates = new HashMap<>();
        exitGates.put(1, exitGate1);
        exitGates.put(2, exitGate2);

        EntranceGate entranceGate1 = new EntranceGate(1);
        EntranceGate entranceGate2 = new EntranceGate(2);

        Map<Integer, EntranceGate> entranceGates = new HashMap<>();
        entranceGates.put(1, entranceGate1);
        entranceGates.put(2, entranceGate2);

        ParkingLot parkingLot = new ParkingLot(1, Arrays.asList(parkingFloor), entranceGates, exitGates);

        ParkingLotService parkingLotService = new ParkingLotService(parkingLot);

        System.out.println("Car Parking system activated ...");

        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String command = br.readLine();
            String[] parts = command.split(" ");

            /*
                Commands ->
                1 entrance_number registration_number car_type
                2 exit_number ticket_number(registration_number)

                //TODO: For exit, we can pass ParkingLot.payment type via command
             */

            switch (parts[0]) {
                case "1":
                    String entranceNumber = parts[1];
                    String registrationNumber = parts[2];
                    String carType = parts[3];
                    VehicleType vehicleType = VehicleType.valueOf(carType);
                    Vehicle vehicle = new Vehicle(registrationNumber, vehicleType);
                    parkingLotService.parkVehicle(vehicle, Integer.parseInt(entranceNumber));
                    break;
                case "2":
                    String exitNumber = parts[1];
                    String ticketNumber = parts[2];
                    parkingLotService.unparkVehicle(ticketNumber, Integer.parseInt(exitNumber));
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}