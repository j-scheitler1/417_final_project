package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void reverseWorks() {
        StringUtils s = new StringUtils();
        assertEquals("cba", s.reverse("abc"));
    }

    @Test
    public void reverseHandlesNull() {
        StringUtils s = new StringUtils();
        assertNull(s.reverse(null));
    }

    @Test
    public void blankCheckWorks() {
        StringUtils s = new StringUtils();
        assertTrue(s.isBlank("   "));
        assertFalse(s.isBlank("hello"));
    }

    @Test
    public void countWordsIgnoresExtraWhitespace() {
        StringUtils s = new StringUtils();
        assertEquals(4, s.countWords("  regression   test   selection demo "));
    }

    @Test
    public void palindromeCheckIgnoresCaseAndPunctuation() {
        StringUtils s = new StringUtils();
        assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(s.isPalindrome("Regression testing"));
    }

    @Test
    public void titleCaseNormalizesInput() {
        StringUtils s = new StringUtils();
        assertEquals("Final Project Report", s.toTitleCase("   fINAL   project REPORT "));
    }
}
