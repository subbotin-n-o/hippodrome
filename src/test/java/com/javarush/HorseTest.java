package com.javarush;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HorseTest extends BaseTest {

    @BeforeEach
    public void initGeneratorRandomDate() {
        randomDate = new GeneratorRandomDate();
    }

    @Test
    @DisplayName("Check exception when first parameter is null")
    @Order(1)
    public void checkExcWhenFirstParamIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));
    }

    @Test
    @DisplayName("Check exception message when first parameter is null")
    @Order(2)
    public void checkExcMessageWhenFirstParamIsNull() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));

        String expectedMessage = "Name cannot be null.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @DisplayName("Check exception when first parameter is empty")
    @ValueSource(strings = {"", "  "})
    @Order(3)
    public void checkExcWhenFirstParamIsEmpty(String horseName) {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(horseName, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));
    }

    @ParameterizedTest
    @DisplayName("Check exception message when first parameter is empty")
    @ValueSource(strings = {"", "  "})
    @Order(4)
    public void checkExcMessageWhenFirstParamIsEmpty(String horseName) {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(horseName, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));

        String expectedMessage = "Name cannot be blank.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Check exception when second parameter negative number")
    @Order(5)
    public void checkExcWhenSecondParamNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomNegativeNumber(), randomDate.getRandomPositiveNumber()));
    }

    @Test
    @DisplayName("Check exception message when second parameter negative number")
    @Order(6)
    public void checkExcMessageWhenSecondParamNegativeNumber() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomNegativeNumber(), randomDate.getRandomPositiveNumber()));

        String expectedMessage = "Speed cannot be negative.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Check exception when third parameter negative number")
    @Order(7)
    public void checkExcWhenThirdParamNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), randomDate.getRandomNegativeNumber()));
    }

    @Test
    @DisplayName("Check exception message when third parameter negative number")
    @Order(8)
    public void checkExcMessageWhenThirdParamNegativeNumber() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), randomDate.getRandomNegativeNumber()));

        String expectedMessage = "Distance cannot be negative.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("getName() return first parameter of constructor")
    @Order(9)
    public void getNameReturnFirstParamOfConstr() {

        String expectedResult = randomDate.getRandomName();
        String actualResult = new Horse(expectedResult, randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber())
                .getName();

        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("getSpeed() return second parameter of constructor")
    @Order(10)
    public void getSpeedReturnSecondParamOfConstr() {

        double expectedResult = randomDate.getRandomPositiveNumber();
        double actualResult = new Horse(randomDate.getRandomName(), expectedResult, randomDate.getRandomPositiveNumber())
                .getSpeed();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getDistance() return third parameter of constructor")
    @Order(11)
    public void getDistanceReturnThirdParamOfConstr() {

        double expectedResult = randomDate.getRandomPositiveNumber();
        double actualResult = new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), expectedResult)
                .getDistance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getDistance() return zero if constructor with two parameters")
    @Order(12)
    public void getDistanceConstrTwoParamReturnZero() {

        double expectedResult = 0;
        double actualResult = new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber())
                .getDistance();

        assertEquals(expectedResult, actualResult);
    }
}