package SnakesAndLadders.model;

public class Jump {

    private Integer startPosition;
    private Integer endPosition;

    public Jump(Integer startPosition, Integer endPosition) {
        this.endPosition = endPosition;
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }
}
