package com.javarush;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HippodromeTest extends BaseTest {

    @BeforeEach
    public void initGeneratorRandomDate() {
        randomDate = new GeneratorRandomDate();
    }

    @Test
    @DisplayName("Check exception when parameter constructors is null")
    @Order(1)
    public void checkExcWhenParamConstrIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hippodrome(null));
    }
}
