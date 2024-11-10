package com.javarush;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GeneratorRandomDate {

    public String getRandomName() {
        return new Faker(Locale.ENGLISH)
                .gameOfThrones()
                .dragon();
    }

    public double getRandomSpeed() {
        return Math.random();
    }

    public double getRandomDistance() {
        return Math.random();
    }
}
