package com.example;

import java.util.Locale;

public class StringUtils {
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public String normalizeWhitespace(String input) {
        if (input == null) {
            return null;
        }
        return input.trim().replaceAll("\\s+", " ");
    }

    public int countWords(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return normalizeWhitespace(input).split(" ").length;
    }

    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String normalized = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        return !normalized.isEmpty() && normalized.equals(reverse(normalized));
    }

    public String toTitleCase(String input) {
        if (isBlank(input)) {
            return "";
        }

        String[] words = normalizeWhitespace(input).toLowerCase(Locale.ROOT).split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            builder.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
            if (i < words.length - 1) {
                builder.append(' ');
            }
        }

        return builder.toString();
    }
}
