package Dice;

/*
*
* This class generates a random die for Yahtzee to generate
*
* */

import java.util.Random;

public class Dice {

    private int rollValue;
    private int sides = 6;

    public void roll(Random random) {
        rollValue = random.nextInt(sides) + 1;
    }

    public int getRollValue() {
        return rollValue;
    }
}
