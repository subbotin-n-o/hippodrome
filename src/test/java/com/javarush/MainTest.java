package com.javarush;

import org.junit.jupiter.api.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MainTest extends BaseTest{

    @Test
    @DisplayName("Check timeout method main()")
    @Timeout(value = 22, unit = SECONDS)
//    @Disabled
    public void mainTimeout() throws Exception {
        Main.main(new String[] {});
    }
}