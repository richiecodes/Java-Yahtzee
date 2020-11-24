package game;

import player.Hand;

import java.util.*;

public class Game {

    private Scanner scanner;
    private int choice;
    private int loop = 0;
    private final int MAX_LOOP = 3;

    Random random = new Random();

    Hand hand = new Hand(5);

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        hand.roll(random);
        System.out.println("\n" + hand);
        decision();
        System.out.println("\n\nTurn ended!");
    }

    private void decision() {
        while (loop < MAX_LOOP) {
            System.out.println("1. Re-Roll Single Die");
            System.out.println("2. Re-Roll Multiple Dice\n");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    rerollSingle();
                    loop++;
                    break;

                case 2:
                    rerollSeveral();
                    loop++;
                    break;
            }
        }
    }

    private void rerollSingle() {
        System.out.println("Which die would you like to reroll?");
        int dieSelected = scanner.nextInt() - 1;
        hand.roll(random, dieSelected);
        System.out.println("\n" + hand);
    }

    private void rerollSeveral() {
        List<Integer> selections = new ArrayList<>();
        System.out.println("\nWhich dice would you like to reroll? (Separate with spaces): ");
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");

        for(String number : inputAsArray) {
            //System.out.println("'" + number + "'");
            if(number.matches("[1-5]"))
                selections.add(Integer.parseInt(number) - 1);
        }

        hand.roll(random, selections);
        System.out.println("\n" + hand);
    }
}
