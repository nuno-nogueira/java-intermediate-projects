package com.shaunwassell.dice;

import java.util.Random;

public class Simulator {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println(rand.nextInt(6) + 1);
    }
}
