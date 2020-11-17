package game;

import Dice.Dice;

import java.util.Random;
/*
*
* This class handles all game logic
*
* */

public class Yahtzee {
    private final int NUM_OF_DICE = 5;
    private Dice[] dice;
    private int rerollFirst = 0;
    private Random rand = new Random();

    public Yahtzee() {
        dice = new Dice[NUM_OF_DICE];

        for (int i = 0; i < NUM_OF_DICE; i++)
            dice[i] = new Dice();
    }

    public void rollDice() {
        for (int i = 0; i < NUM_OF_DICE; i++)
            dice[i].roll(rand);
    }

    public void printDiceValues() {
        System.out.println();

        for (int i = 0; i < NUM_OF_DICE; i++)
            System.out.println("Dice [" + (i + 1) + "] rolled a " + dice[i].getRollValue());

        System.out.println();
    }


    public void rerollFirst() {
        dice[0].roll(rand);

        for (int i = 0; i < NUM_OF_DICE; i++) {

            if (i == 0) {

                String newNumber = ("\nDice [" + (i + 1) + "] now rolls a (" + dice[i].getRollValue() + ")");
                System.out.println(newNumber.toUpperCase());

            } else if (i >= 1)
                System.out.println("Dice [" + (i + 1) + "] rolled a (" + dice[i].getRollValue() + ")");
        }

        System.out.println();
    }

    public void rerollSpecific(String choice) {
        int choose = Integer.parseInt(choice) - 1;
        dice[choose].roll(rand);

        for (int i = 0; i < NUM_OF_DICE; i++) {

            if (i == choose) {

                String newNumber = ("Dice [" + (i + 1) + "] now rolls a (" + dice[i].getRollValue() + ")");
                System.out.println(newNumber.toUpperCase());

            } else if (i != choose)
                System.out.println("Dice [" + (i + 1) + "] rolled a (" + dice[i].getRollValue() + ")");
        }
    }

    public void game() {
        rollDice();
        printDiceValues();
    }
}
