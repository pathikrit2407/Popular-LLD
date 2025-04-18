package ParkingLot.payment.strategy;

import ParkingLot.models.Ticket;

public interface PaymentStrategy {

    public Boolean process(Ticket ticket);
}
