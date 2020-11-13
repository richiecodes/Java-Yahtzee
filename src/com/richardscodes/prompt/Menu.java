package com.richardscodes.prompt;

import com.richardscodes.Yahtzee;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private int loopCount = 0;
    private Yahtzee yahtzee = new Yahtzee();

    public void mainMenu(Scanner scanner) {
        this.scanner = scanner;
        if (loopCount <= 0) {
            System.out.println("Welcome!");
        }
        System.out.println("Please select an option:\n");
        System.out.println("1. Play Game");
        System.out.println("2. Exit\n");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                yahtzee.game();
                loopCount++;
                rerollDice();
                break;

            case "2":
                System.out.println("Have a good day!");
                loopCount++;
                break;

            default:
                System.out.println("PLEASE ENTER VALID INPUT\n\n");
                loopCount++;
                mainMenu(scanner);
                break;
        }

    }

    public void rerollDice() {
        System.out.println("What would you like to do?");
        System.out.println("1. Reroll First Dice");
        System.out.println("2. Reroll specific dice");
        System.out.println("3. Back to main menu");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                yahtzee.rerollFirst();
                rerollDice();
                break;

            case "2":
                System.out.println("Which dice would you like to reroll?:");
                String diceChoice = scanner.nextLine();
                int choose = Integer.parseInt(diceChoice);
                if (choose > 5) {
                    System.out.println("PLEASE ENTER VALID INPUT!\n");
                    rerollDice();
                    return;
                }
                yahtzee.rerollSpecific(diceChoice);
                break;

            case "3":
                loopCount = 0;
                mainMenu(scanner);
                break;

            default:
                System.out.println("PLEASE ENTER VALID INPUT!\n");
                rerollDice();
                break;
        }
    }
}
