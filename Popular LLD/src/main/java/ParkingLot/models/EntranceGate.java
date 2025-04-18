package ParkingLot.models;

import java.time.LocalDate;

public class EntranceGate {

    private Integer entranceNumber;

    public EntranceGate (Integer entranceNumber) {
       this.entranceNumber = entranceNumber;
    }

    public Ticket generateTicket(Vehicle vehicle, String parkingSlotId, String floorId) {
        Ticket ticket = new Ticket(LocalDate.now(), vehicle, parkingSlotId, floorId);
        ticket.setEntranceNumber(entranceNumber);
        return ticket;
    }


    public Integer getEntranceNumber() {
        return entranceNumber;
    }

    public void setEntranceNumber(Integer entranceNumber) {
        this.entranceNumber = entranceNumber;
    }
}
