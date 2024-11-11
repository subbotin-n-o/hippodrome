package com.javarush;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class HorseTest {

    GeneratorRandomDate randomDate = new GeneratorRandomDate();

    @Test
    @DisplayName("Check exception when first parameter is null")
    public void A_CheckExcWhenFirstParamIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomSpeed(), randomDate.getRandomDistance()));
    }

    @Test
    @DisplayName("Check exception message when first parameter is null")
    public void B_CheckExcMessageWhenFirstParamIsNull() {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomSpeed(), randomDate.getRandomDistance()));

        String expectedMessage = "Name cannot be null.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @DisplayName("Check exception when first parameter is empty")
    @ValueSource(strings = { "", "  "})
    public void C_CheckExcWhenFirstParamIsEmpty(String horseName) {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(horseName, randomDate.getRandomSpeed(), randomDate.getRandomDistance()));
    }

    @ParameterizedTest
    @DisplayName("Check exception message when first parameter is empty")
    @ValueSource(strings = { "", "  "})
    public void D_CheckExcMessageWhenFirstParamIsEmpty(String horseName) {
        Exception exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new Horse(horseName, randomDate.getRandomSpeed(), randomDate.getRandomDistance()));

        String expectedMessage = "Name cannot be blank.";
        String actualMessage = exceptionMessage.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}