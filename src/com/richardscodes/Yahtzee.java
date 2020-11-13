package com.richardscodes;

import com.richardscodes.Dice.Dice;

public class Yahtzee {
    //Initialize 5 die
    private final int NUM_OF_DICE = 5;
    //private int rollCount = 3;
    private Dice[] dice;
    private int rerollFirst = 0;

    public Yahtzee() {
        dice = new Dice[NUM_OF_DICE];
        for (int i = 0; i < NUM_OF_DICE; i++) {
            dice[i] = new Dice();
        }
        rollDice();
    }

    public void rollDice() {
        for (int i = 0; i < NUM_OF_DICE; i++) {
            dice[i].roll();
        }
    }

    public void printDiceValues() {
        for (int i = 0; i < NUM_OF_DICE; i++) {
            System.out.println("Dice " + (i + 1) + " rolled a " + dice[i].getRollValue());
        }
        System.out.println();
    }


    public void rerollFirst() {
        dice[0].roll();
        for (int i = 0; i < NUM_OF_DICE; i++) {
            if (i == 0) {
                System.out.println("Dice " + (i + 1) + " now rolls a " + dice[i].getRollValue());
            } else if (i >= 1) {
                System.out.println("Dice " + (i + 1) + " rolled a " + dice[i].getRollValue());
            }
        }
        System.out.println();
    }

    public void rerollSpecific(String choice) {
        int choose = Integer.parseInt(choice) - 1;
        dice[choose].roll();

        for (int i = 0; i < NUM_OF_DICE; i++) {
            if (i == choose) {
                System.out.println("Dice " + (i + 1) + " now rolls a " + dice[i].getRollValue());
            } else if (i != choose)
                System.out.println("Dice " + (i + 1) + " rolled a " + dice[i].getRollValue());
        }
    }
}
