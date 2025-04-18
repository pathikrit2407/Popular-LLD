package ParkingLot.payment.factory;

import ParkingLot.payment.strategy.CardPaymentStrategy;
import ParkingLot.payment.strategy.CashPaymentStrategy;
import ParkingLot.payment.strategy.PaymentStrategy;

public class PaymentFactory {

    public static PaymentStrategy getPaymentFactory(Integer paymentOption) {
        //Get choice of user
        PaymentStrategy paymentStrategy;

        switch(paymentOption) {
            case 1: paymentStrategy = new CardPaymentStrategy();
            break;
            case 2: paymentStrategy = new CashPaymentStrategy();
            break;
            default:
                throw new RuntimeException("Please select valid ParkingLot.payment option");
        }

        return paymentStrategy;
    }
}
