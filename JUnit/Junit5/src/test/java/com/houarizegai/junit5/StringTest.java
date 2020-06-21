package com.houarizegai.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void test() {
        int actualLength = "Houari".length();
        int expectedLength = 6;
        assertEquals(expectedLength, actualLength);

        int actualOutput = Math.abs(-10);
        int expectedOutput = 10;
        assertEquals(expectedOutput, actualOutput);
    }
}
