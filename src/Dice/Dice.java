package Dice;

/*
*
* This class generates a random die for Yahtzee to generate
*
* */

public class Dice {

    private int rollValue;

    public void roll() {
        rollValue = (int) (Math.round(Math.random() * 6) + 1);
    }

    public int getRollValue() {
        return rollValue;
    }
}
