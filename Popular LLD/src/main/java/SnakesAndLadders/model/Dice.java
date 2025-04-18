package SnakesAndLadders.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private Integer diceCount;
    private Integer minDiceValue;
    private Integer maxDiceValue;

    public Dice(Integer diceCount, Integer minDiceValue, Integer maxDiceValue) {
        this.diceCount = diceCount;
        this.minDiceValue = minDiceValue;
        this.maxDiceValue = maxDiceValue;
    }

    // rolling dice method
    public Integer rollDice() {
        Integer totalDiceValue = 0, rolledDiceCount = 0;

        while(!rolledDiceCount.equals(diceCount)) {
            int diceValue = ThreadLocalRandom.current().nextInt(minDiceValue, maxDiceValue);
            totalDiceValue += diceValue;
            rolledDiceCount++;
        }


        return totalDiceValue;
    }
}
