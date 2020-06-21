package com.houarizegai.junit5;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests (open connection, init database, ...)");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests (close network & database, cleanup data, ...)");
    }

    @BeforeEach // like: Before (JUnit 4)
    void beforeEach(TestInfo info) {
        System.out.println("Initialize test data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("After each test (like: clean up test data) " + info.getDisplayName());
    }

    @Test
    void lengthBasic() {
        var actualLength = "Houari".length();
        var expectedLength = 6;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    @DisplayName("When string is null, throw an exception.")
    void lengthException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            int strLength = str.length();
        });
    }

    @Test
    void toUpperCaseBasic() {
        var str = "mohamed";
        var result = str.toUpperCase();
        assertNotNull(result);
        //assertNull(result);
        assertEquals("MOHAMED", result);
    }

    @Test
    void containsBasic() {
        /*String str = "Welcome to Java";
        boolean result = str.contains("Kotlin");
        assertFalse(result); // or: assertEquals(false, result);*/
        assertFalse("Welcome to Java".contains("Kotlin"));
    }

    @Test
    @RepeatedTest(5) // Repeat the test
    void splitBasic() {
        var result = "ab cd ef".split(" ");
        var expectedOutput = new String[]{"ab", "cd", "ef"};
        assertArrayEquals(expectedOutput, result);
    }

    // Using parameterized test (same test for different values)
    @ParameterizedTest
    @ValueSource(strings = {"houari", "mohamed", "omar", "cc"})
    void lengthGreaterThan(String str) {
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"Houari, HOUARI", "'',''", "a, A", "dz, DZ"})
    void upperCase(String word, String capitalizedWord) {
        assertEquals(capitalizedWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is: {1}")
    @CsvSource(value = {"Mohamed, 7", "Apple, 5", "'', 0", "blabla, 6"})
    void lengthTests(String str, int expectedLength) {
        assertEquals(expectedLength, str.length());
    }
}
