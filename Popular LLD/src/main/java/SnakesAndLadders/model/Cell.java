package SnakesAndLadders.model;

public class Cell {
    //Can be Ladder or snake based on the start and end position of jump object
    private Jump jumpObject;

    public Jump getJumpObject() {
        return jumpObject;
    }

    public void setJumpObject(Jump jumpObject) {
        this.jumpObject = jumpObject;
    }
}
