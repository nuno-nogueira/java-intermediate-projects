package com.shaunwassell.passwords;

import java.util.Random;

public class PasswordGenerator {
    String generatePassword(int length, boolean useLowercase, boolean useUppercase,
                            boolean useNumbers, boolean useSpecialChars) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()?";

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            char nextLetter = lowercase.charAt(rand.nextInt(lowercase.length()));
            password.append(nextLetter);
        }

        return password.toString();
    }
}
