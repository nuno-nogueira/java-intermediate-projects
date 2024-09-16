package com.shaunwassell.passwords;

import java.util.Random;

public class PasswordGenerator {
    String generatePassword(int length, boolean useLowercase, boolean useUppercase,
                            boolean useNumbers, boolean useSpecialChars) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()?";

        StringBuilder charOptions = new StringBuilder();

        if (useLowercase) {
            charOptions.append(lowercase);
        }

        if (useUppercase) {
            charOptions.append(uppercase);
        }

        if (useNumbers) {
            charOptions.append(digits);
        }

        if (useSpecialChars) {
            charOptions.append(symbols);
        }

        String allChars = charOptions.toString();

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            char nextLetter = allChars.charAt(rand.nextInt(allChars.length()));
            password.append(nextLetter);
        }

        return password.toString();
    }
}
