package com.nunonogueira.dice;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean appCompleted = false;
        int score = 0;
        do {
            try {
                System.out.println("How many dice would you like to roll?");
                int numOfDice = scanner.nextInt();

                appCompleted = true;

                if (numOfDice == 0) break;

                System.out.println("About to roll " + numOfDice + " dice");

                Random rand = new Random();
                for (int i = 0; i < numOfDice ; i++) {

                    int rolledNumber = rand.nextInt( 9) + 1;

                    score += rolledNumber;
                    System.out.println(display(rolledNumber));

                }
                System.out.println("Your dice score is " + score);
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid number!");
                scanner.next();
            }
        } while (!appCompleted);
    }

    static String display(int value) {

        switch(value) {
            case 1:
                return "---------\n|       |\n|   •   |\n|     • |\n---------";
            case 2:
                return "---------\n| •     |\n|       |\n|     • |\n---------";
            case 3:
                return "---------\n| •     |\n|   •   |\n|     • |\n---------";
            case 4:
                return "---------\n| •   • |\n|       |\n| •   • |\n---------";
            case 5:
                return "---------\n| •   • |\n|   •   |\n| •   • |\n---------";
            case 6:
                return "---------\n| •   • |\n| •   • |\n| •   • |\n---------";
            case 7:
                return "---------\n| •   • |\n| • • • |\n| •   • |\n---------";
            case 8:
                return "---------\n| • • • |\n| •   • |\n| • • • |\n---------";
            case 9:
                return "---------\n| • • • |\n| • • • |\n| • • • |\n---------";
            default:
                return "Not a valid die value";
        }
    }
}
