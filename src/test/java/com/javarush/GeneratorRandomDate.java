package com.javarush;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GeneratorRandomDate {

    public String getRandomName() {
        return new Faker(Locale.ENGLISH)
                .gameOfThrones()
                .dragon();
    }

    public double getRandomPositiveNumber() {
        return Math.random();
    }

    public double getRandomNegativeNumber() {
        return Math.random() * -1;
    }
}
