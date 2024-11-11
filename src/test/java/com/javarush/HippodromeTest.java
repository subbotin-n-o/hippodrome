package com.javarush;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HippodromeTest extends BaseTest {

    @BeforeEach
    public void initGeneratorRandomDate() {
        randomDate = new GeneratorRandomDate();
    }

    @Test
    @DisplayName("Check exception, when parameter of constructor is null")
    @Order(1)
    public void checkExcWhenParamConstrIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(null));
    }

    @Test
    @DisplayName("Check exception message, when parameter of constructor is null")
    @Order(2)
    public void checkExcMessageWhenFirstParamIsNull() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(null));

        String expectedMessage = "Horses cannot be null.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Check exception, when parameter of constructor empty List")
    @Order(3)
    public void checkExcWhenParamConstrEmptyList() {
        List<Horse> emptyList = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(emptyList));
    }

    @Test
    @DisplayName("Check exception message, when parameter of constructor empty List")
    @Order(4)
    public void checkExcMessageWhenParamConstrEmptyList() {
        List<Horse> emptyList = new ArrayList<>();

        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(emptyList));

        String expectedMessage = "Horses cannot be empty.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("getHorses return list equal to list from constructor")
    @Order(5)
    public void getHorsesReturnListEqualsListFromConstr() {
        List<Horse> expectedResult = getHorseList();
        List<Horse> actualResult = new Hippodrome(expectedResult).getHorses();

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), actualResult.get(i));
        }
    }

    private List<Horse> getHorseList() {
        List<Horse> horsesList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horsesList.add(new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));
        }
        return horsesList;
    }
}