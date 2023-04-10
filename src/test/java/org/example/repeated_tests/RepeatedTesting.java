package org.example.repeated_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTesting {
    @Test
    @DisplayName("Test without repetition")
    void test_without_repetition(){
        assertTrue(true);
    }

    @RepeatedTest(value = 3, name = "{displayName} --> Repetition n° {currentRepetition} of {totalRepetitions}")
    @DisplayName("Test with repetition")
    void test_with_repetition(RepetitionInfo info){
        System.out.println("Current repetition: " + info.getCurrentRepetition());
        assertTrue(true);
    }
}
