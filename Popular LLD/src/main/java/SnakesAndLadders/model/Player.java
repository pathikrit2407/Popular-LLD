package SnakesAndLadders.model;

public class Player {

    private String playerName;
    private Integer currentPosition;

    public Player(String playerName, Integer currentPosition) {
        this.currentPosition = currentPosition;
        this.playerName = playerName;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
