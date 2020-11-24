package player;

import Die.Die;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
    private List<Die> dice = new ArrayList<>();
    private int numOfDice;

    public Hand(int numOfDice) {
        this.numOfDice = numOfDice;
        for (int i = 0; i < numOfDice; i++) {
            dice.add(new Die());
        }
    }

    public void roll(Random random) {
        for(var die : dice) {
            die.roll(random);
        }
    }

    public void roll(Random random, int choice) {
        dice.get(choice).roll(random);
    }

    public void roll(Random random, List<Integer> choices) {
        for(int choice : choices) {
            roll(random, choice);
        }
    }

    @Override
    public String toString() {
        String output = "";

        for(var die : dice) {
            output += "[" + die.getValue() + "]" + "\t";
        }

        return output;
    }

    public int getDice() {
        return numOfDice;
    }
}
