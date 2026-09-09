package com.nunonogueira.wordgame;

import java.util.Scanner;

public class App {

    public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the difficulty: \n 1 - Easy;\n 2 - Medium;\n 3 - Hard;\n----------");

        int wins = 0;
        int losses = 0;
        int difficulty = scanner.nextInt();

        WordGuessingGame game;
        do {
            switch (difficulty) {
                case 1:
                    if(!runGame(10, wins, losses)) break;
                case 2:
                    if(!runGame(8, wins, losses)) break;
                case 3:
                    if(!runGame(6, wins, losses)) break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Select the difficulty: \n 1 - Easy;\n 2 - Medium;\n 3 - Hard;\n----------");
                    difficulty = scanner.nextInt();
            }
        } while (difficulty < 1 && difficulty > 3);
    }

    public boolean playAgain() {
        System.out.println("Would you like to play again? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        boolean answer = scanner.nextLine().toLowerCase().equals("y");
        return answer;
    }

    public boolean runGame(int maxAttempts, int wins, int losses) {
        String[] words = {"java", "programming", "class", "computer", "method"};

        WordGuessingGame game = new WordGuessingGame(words, maxAttempts);

        if (game.play()) {
            wins++;
        } else {
            losses++;
        }

        System.out.println("You currently have " + wins + " wins and " + losses + " losses!");
        if (!playAgain()) return false;

        return true;
    }
}
