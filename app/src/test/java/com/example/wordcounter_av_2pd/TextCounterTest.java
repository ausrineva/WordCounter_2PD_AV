package com.example.wordcounter_av_2pd;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextCounterTest {

    // Testai žodžių skaičiavimo funkcijai
    @Test
    public void testCountWords_emptyText() {
        int result = TextCounter.countWords("");
        assertEquals(0, result);  // Tikimasi 0
    }

    @Test
    public void testCountWords_onlySpaces() {
        int result = TextCounter.countWords("     ");
        assertEquals(0, result);  // Tikimasi 0
    }

    @Test
    public void testCountWords_normalText() {
        int result = TextCounter.countWords("Hello world!");
        assertEquals(2, result);  // Tikimasi 2
    }

    @Test
    public void testCountWords_withTabs() {
        int result = TextCounter.countWords("\tHello\tworld\t");
        assertEquals(2, result);  // Tikimasi 2
    }

    @Test
    public void testCountWords_withNewLines() {
        int result = TextCounter.countWords("Hello\nworld");
        assertEquals(2, result);  // Tikimasi 2
    }

    @Test
    public void testCountWords_withPunctuation() {
        int result = TextCounter.countWords("Hello, world! This is a test.");
        assertEquals(6, result);  // Tikimasi 6
    }

    // Testai simbolių skaičiavimo funkcijai
    @Test
    public void testCountCharacters_emptyText() {
        int result = TextCounter.countCharacters("");
        assertEquals(0, result);  // Tikimasi 0
    }

    @Test
    public void testCountCharacters_onlySpaces() {
        int result = TextCounter.countCharacters("     ");
        assertEquals(5, result);  // Tikimasi 5
    }

    @Test
    public void testCountCharacters_normalText() {
        int result = TextCounter.countCharacters("Hello world!");
        assertEquals(12, result);  // Tikimasi 12
    }

    @Test
    public void testCountCharacters_withTabs() {
        int result = TextCounter.countCharacters("\tHello\tworld\t");
        assertEquals(13, result);  // Tikimasi 13
    }

    @Test
    public void testCountCharacters_withNewLines() {
        int result = TextCounter.countCharacters("Hello\nworld");
        assertEquals(11, result);  // Tikimasi 11
    }

    @Test
    public void testCountCharacters_withPunctuation() {
        int result = TextCounter.countCharacters("Hello, world!");
        assertEquals(13, result);  // Tikimasi 13
    }


}
