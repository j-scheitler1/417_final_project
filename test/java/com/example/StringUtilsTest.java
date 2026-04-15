package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void reverseWorks() {
        StringUtils s = new StringUtils();
        assertEquals("cba", s.reverse("abc"));
    }

    @Test
    void reverseHandlesNull() {
        StringUtils s = new StringUtils();
        assertNull(s.reverse(null));
    }

    @Test
    void blankCheckWorks() {
        StringUtils s = new StringUtils();
        assertTrue(s.isBlank("   "));
        assertFalse(s.isBlank("hello"));
    }

    @Test
    void countWordsIgnoresExtraWhitespace() {
        StringUtils s = new StringUtils();
        assertEquals(4, s.countWords("  regression   test   selection demo "));
    }

    @Test
    void palindromeCheckIgnoresCaseAndPunctuation() {
        StringUtils s = new StringUtils();
        assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(s.isPalindrome("Regression testing"));
    }

    @Test
    void titleCaseNormalizesInput() {
        StringUtils s = new StringUtils();
        assertEquals("Final Project Report", s.toTitleCase("   fINAL   project REPORT "));
    }
}
