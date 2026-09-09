package com.nunonogueira.wordgame;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private static String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordList, int maxAttempts) {
        Random rand = new Random();
        this.wordToGuess = wordList[rand.nextInt(wordList.length)];
        this.guessedLetters = new char[this.wordToGuess.length()];

        for (int i = 0; i < this.guessedLetters.length; i++) {
            this.guessedLetters[i] = '_';
        }

        this.attempts = maxAttempts;
    }

    public boolean play() {

        Scanner scanner = new Scanner(System.in);
        boolean userHasWon = false;

        while (this.attempts > 0 && !userHasWon) {

            displayState();
            System.out.println("You have " + this.attempts + " attempts left...");
            System.out.println("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (!processGuess(guess)) {
                System.out.println("Incorrect! The letter '" + guess + "' was not in the secret word! D:");
                this.attempts--;
            } else {
                System.out.println("Correct! The letter '" + guess + "' is in the secret word! :D");
                if (new String(guessedLetters).equals(this.wordToGuess)) {
                    System.out.println("CONGRATULATIONS! You guessed the word '" + this.wordToGuess + "'!");
                    userHasWon = true;
                }
            }
        }

        if (!userHasWon) {
            System.out.println("You wasted all your attempts! The word was '" + this.wordToGuess + "'!");
        }

        return userHasWon;
    }

    private boolean processGuess(char letter) {
        boolean letterFound = false;

        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if (this.wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private void displayState() {
        System.out.println("Guessed letters ->" + new String(guessedLetters));
    }
}
