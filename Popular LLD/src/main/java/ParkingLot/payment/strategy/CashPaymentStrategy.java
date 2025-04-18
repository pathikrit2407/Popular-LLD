package ParkingLot.payment.strategy;

import ParkingLot.models.Ticket;

import java.time.Duration;
import java.time.LocalDate;

public class CashPaymentStrategy implements PaymentStrategy {

    private Integer pricePerHour = 10;

    @Override
    public Boolean process(Ticket ticket) {
        Long totalHours = Duration.between(LocalDate.now(), ticket.getEntryTime()).toHours();
        System.out.println("Total cash paid is " + totalHours * pricePerHour);
        return true;
    }
}
