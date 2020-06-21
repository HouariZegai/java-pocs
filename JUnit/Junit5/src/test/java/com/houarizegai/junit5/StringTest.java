package com.houarizegai.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class StringTest {

    @BeforeEach // like: Before (JUnit 4)
    void beforeEach(TestInfo info) {
        System.out.println("Initialize test data for " + info.getDisplayName());
    }

    @Test
    void lengthBasic() {
        var actualLength = "Houari".length();
        var expectedLength = 6;
        assertEquals(expectedLength, actualLength);
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
    void splitBasic() {
        var result = "ab cd ef".split(" ");
        var expectedOutput = new String[]{"ab", "cd", "ef"};
        assertArrayEquals(expectedOutput, result);
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("After each test (like: clean up test data) " + info.getDisplayName());
    }
}
