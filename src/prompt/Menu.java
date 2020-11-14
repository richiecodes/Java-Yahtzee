package prompt;

import game.Yahtzee;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private int loopCount = 0;
    private Yahtzee yahtzee = new Yahtzee();

    public void mainMenu() {
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
                decision();
                break;

            case "2":
                System.out.println("Have a good day!");
                loopCount++;
                break;

            default:
                System.out.println("PLEASE ENTER VALID INPUT\n\n");
                loopCount++;
                mainMenu();
                break;
        }

    }

    public void decision() {
        System.out.println("What would you like to do?");
        System.out.println("1. Reroll First Dice");
        System.out.println("2. Reroll specific dice");
        System.out.println("3. Back to main menu");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                yahtzee.rerollFirst();
                decision();
                break;

            case "2":
                System.out.println("Which dice would you like to reroll?:");
                String diceChoice = scanner.nextLine();
                int choose = Integer.parseInt(diceChoice);
                if (choose > 5) {
                    System.out.println("PLEASE ENTER VALID INPUT!\n");
                    decision();
                    return;
                }
                yahtzee.rerollSpecific(diceChoice);
                break;

            case "3":
                loopCount = 0;
                mainMenu();
                break;

            default:
                System.out.println("PLEASE ENTER VALID INPUT!\n");
                decision();
                break;
        }
    }
}
