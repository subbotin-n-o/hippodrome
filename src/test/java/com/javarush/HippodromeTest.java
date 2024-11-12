package com.javarush;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
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
    @DisplayName("getHorses() return list equal to list from constructor")
    @Order(5)
    public void getHorsesReturnListEqualsListFromConstr() {
        List<Horse> expectedResult = getHorseList(new Horse(randomDate.getRandomName(),
                randomDate.getRandomPositiveNumber(),
                randomDate.getRandomPositiveNumber()),
                30);
        List<Horse> actualResult = new Hippodrome(expectedResult).getHorses();

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), actualResult.get(i));
        }
    }

    @Mock
    Horse mockHorse;

    @Test
    @DisplayName("move() call method move() on all objects")
    @Order(6)
    public void moveCallMethodOnAllObjects() {
        Hippodrome hippodrome = new Hippodrome(getHorseList(mockHorse, 50));
        hippodrome.move();

        Mockito.verify(mockHorse, Mockito.times(50)).move();
    }

    @Test
    @DisplayName("getWinner() return object with the big distance value")
    @Order(7)
    public void getWinnerReturnObjectWithBigDistanceValue() {
        Hippodrome hippodrome = new Hippodrome(getHorseList(5));

        Horse expectedResult = getObjWithBigDistanceValue(hippodrome);
        Horse actualResult = hippodrome.getWinner();

        assertEquals(expectedResult, actualResult);
    }

    private Horse getObjWithBigDistanceValue(Hippodrome hippodrome) {
        return hippodrome.getHorses().stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();
    }

    private List<Horse> getHorseList(int size) {
        List<Horse> horsesList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            horsesList.add(new Horse(randomDate.getRandomName(), randomDate.getRandomPositiveNumber(), randomDate.getRandomPositiveNumber()));
        }
        return horsesList;
    }

    private List<Horse> getHorseList(Horse object, int size) {
        List<Horse> horsesList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            horsesList.add(object);
        }
        return horsesList;
    }
}