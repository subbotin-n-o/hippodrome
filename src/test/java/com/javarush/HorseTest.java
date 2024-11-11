package com.javarush;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HorseTest {

    GeneratorRandomDate randomDate = new GeneratorRandomDate();

    @Test
    @DisplayName("Check exception when first parameter is null")
    @Order(1)
    public void CheckExcWhenFirstParamIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));
    }

    @Test
    @DisplayName("Check exception message when first parameter is null")
    @Order(2)
    public void CheckExcMessageWhenFirstParamIsNull() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));

        String expectedMessage = "Name cannot be null.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @DisplayName("Check exception when first parameter is empty")
    @ValueSource(strings = { "", "  "})
    @Order(3)
    public void CheckExcWhenFirstParamIsEmpty(String horseName) {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(horseName, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));
    }

    @ParameterizedTest
    @DisplayName("Check exception message when first parameter is empty")
    @ValueSource(strings = { "", "  "})
    @Order(4)
    public void CheckExcMessageWhenFirstParamIsEmpty(String horseName) {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(horseName, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));

        String expectedMessage = "Name cannot be blank.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Check exception when second parameter negative number")
    @Order(5)
    public void CheckExcWhenSecondParamNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomNegativeNumber(), randomDate.getRandomPositiveNumber()));
    }

    @Test
    @DisplayName("Check exception message when second parameter negative number")
    @Order(6)
    public void CheckExcMessageWhenSecondParamNegativeNumber() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomNegativeNumber(), randomDate.getRandomPositiveNumber()));

        String expectedMessage = "Speed cannot be negative.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Check exception when third parameter negative number")
    @Order(7)
    public void CheckExcWhenThirdParamNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), randomDate.getRandomNegativeNumber()));
    }

    @Test
    @DisplayName("Check exception message when third parameter negative number")
    @Order(8)
    public void CheckExcMessageWhenThirdParamNegativeNumber() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), randomDate.getRandomNegativeNumber()));

        String expectedMessage = "Distance cannot be negative.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}