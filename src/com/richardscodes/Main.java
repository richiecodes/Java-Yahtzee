package com.richardscodes;
import com.richardscodes.Dice.Dice;
import com.richardscodes.prompt.Menu;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu(scan);

    }
}