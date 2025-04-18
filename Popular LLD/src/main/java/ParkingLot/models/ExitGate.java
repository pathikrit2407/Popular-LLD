package ParkingLot.models;

import ParkingLot.payment.factory.PaymentFactory;
import ParkingLot.payment.strategy.PaymentStrategy;

public class ExitGate {

    private Integer exitNumber;

    public ExitGate(Integer exitNumber) {
        this.exitNumber = exitNumber;
    }

    public void paymentProcessing(Ticket ticket) {
        //We can take ParkingLot.payment choice from user at entrance gate itself or in the code driver
        PaymentStrategy paymentStrategy = PaymentFactory.getPaymentFactory(1);
        paymentStrategy.process(ticket);
        System.out.println("Payment has been done in exit number " + exitNumber);
    }
}
