package com.nunonogueira.passwords;

import java.util.Random;

public class PasswordGenerator {

    String generatePassword(int length, boolean useLowercase, boolean useUpperCase,
                            boolean useNumbers, boolean useSpecialChars) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String symbols = "!#$%^&*(()_+<>,.?{}";

        StringBuilder charOptions = new StringBuilder();

        if (useLowercase) charOptions.append(lowercase);
        if (useUpperCase) charOptions.append(uppercase);
        if (useNumbers) charOptions.append(digits);
        if (useSpecialChars) charOptions.append(symbols);

        String allChars = charOptions.toString();

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        if (useLowercase && password.length() < length) password.append(lowercase.charAt(rand.nextInt(lowercase.length())));
        if (useUpperCase && password.length() < length) password.append(uppercase.charAt(rand.nextInt(uppercase.length())));
        if (useNumbers && password.length() < length) password.append(digits.charAt(rand.nextInt(digits.length())));
        if (useSpecialChars && password.length() < length) password.append(symbols.charAt(rand.nextInt(symbols.length())));

        if (password.length() < length) {
            for (int i = 0; i < length; i++) {
                char nextLetter = allChars.charAt(rand.nextInt(allChars.length()));
                password.append(nextLetter);
            }
        }

        return password.toString();
    }
}
