package ParkingLot.enums;

public enum CommandEnums {
    PARK(1),
    UNPARK(2);

    private int commandNum;

    CommandEnums(Integer num) {
        this.commandNum = num;
    }

    public int getCommandNum() {
        return this.commandNum;
    }
}
