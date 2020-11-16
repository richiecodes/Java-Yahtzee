// Yahtzee
// Written by Richard DeLuca
// #CareerDevs

package com.richardscodes;

import prompt.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.mainMenu();
    }
}