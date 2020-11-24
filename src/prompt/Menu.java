package prompt;


import game.Game;

import java.util.Scanner;

/*
*
* This class handles the menu system
*
* */

public class Menu {
    private Scanner scanner;
    private int loopCount = 0;
    private int numOfTurns = 0;

    public Menu (Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainMenu() { //Handles the menu users see when they first start the program
        System.out.println("Welcome to Yahtzee!");
        System.out.print("\nWhat would you like to do?\n");
        displayOptions();
        System.out.print("\nChoice:\n");
        String choice = scanner.nextLine();

        switch(choice) {
            case "1":
                Game game = new Game(scanner);
                game.start();
                break;

            case "2":
                System.out.println("Have a good day!");
                scanner.close();
                break;

            default:
                System.out.println("Please enter a valid option!\n");
                mainMenu();
                break;
        }
    }

    private void displayOptions() {
        System.out.println("1. Play Game");
        System.out.println("2. Exit");
    }
}
