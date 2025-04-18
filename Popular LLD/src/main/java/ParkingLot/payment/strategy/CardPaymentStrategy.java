package ParkingLot.payment.strategy;

import ParkingLot.models.Ticket;

public class CardPaymentStrategy implements PaymentStrategy {

    private final Integer pricePerHour = 5;

    @Override
    public Boolean process(Ticket ticket) {
        //TODO: Need to check why this LocalDate logic not working
        //Long totalHours = Duration.between(LocalDate.now(), ticket.getEntryTime()).toHours();
        System.out.println("Payment done by card for Rs." + 2*pricePerHour);
        return true;
    }
}
