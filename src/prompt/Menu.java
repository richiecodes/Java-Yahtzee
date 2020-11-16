package prompt;

import game.Yahtzee;

import java.util.Scanner;

/*
*
* This class handles the menu system
*
* */

public class Menu {
    private Scanner scanner;
    private int loopCount = 0;
    private Yahtzee yahtzee = new Yahtzee();

    public Menu (Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainMenu() { //Handles the menu users see when they first start the program
        if (loopCount <= 0)
            System.out.println("Welcome!");
        System.out.print("\nPlease select an option:\n");
        System.out.println("1. Play Game");
        System.out.println("2. Exit\n");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                loopCount++;
                yahtzee.game();
                decision();
                break;

            case "2":
                scanner.close();
                System.out.println("\nHave a good day!");
                break;

            default:
                System.out.println("\nInvalid input. Please try again...\n\n");
                loopCount++;
                mainMenu();
                break;
        }

    }

    public void decision() { //This sub-menu handles the user's decision after 5 dice are rolled
        System.out.println("\n" +
                "What would you like to do?");
        System.out.println("1. Reroll first dice");
        System.out.println("2. Reroll specific dice");
        System.out.println("3. Back to main menu\n");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                yahtzee.rerollFirst();
                decision();
                break;

            case "2":
                System.out.println("\nWhich dice would you like to reroll?:\n");
                System.out.print("Choice: ");
                String diceChoice = scanner.nextLine();
                int choose = Integer.parseInt(diceChoice);
                if (choose > 5 || choose <= 0) {
                    System.out.println("\nInvalid input. Please try again...\n");
                    decision();
                    return;
                }
                System.out.println();
                yahtzee.rerollSpecific(diceChoice);
                decision();
                break;

            case "3":
                clearScreen();
                mainMenu();
                break;

            default:
                System.out.println("\nInvalid input. Please try again...\n");
                decision();
                break;
        }
    }

    private void clearScreen() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("\n");
        }
    }
}
