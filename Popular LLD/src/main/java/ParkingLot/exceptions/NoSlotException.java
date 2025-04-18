package ParkingLot.exceptions;

public class NoSlotException extends RuntimeException {

    public NoSlotException(String message) {
        super(message);
    }

    public NoSlotException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
