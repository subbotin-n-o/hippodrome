package com.javarush;

import org.junit.jupiter.api.*;

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
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, randomDate.getRandomSpeed(), randomDate.getRandomDistance()));

        String expectedMessage = "Name cannot be null.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}