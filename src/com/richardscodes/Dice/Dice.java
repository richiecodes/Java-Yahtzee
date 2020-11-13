package com.richardscodes.Dice;

public class Dice {
    //Roll Method
    //Die has random value each roll
    private int rollValue;

    public void roll() {
        rollValue = (int) (Math.round(Math.random() * 6) + 1);
    }

    public int getRollValue() {
        return rollValue;
    }
}
