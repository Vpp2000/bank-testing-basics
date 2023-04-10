package org.example.repeated_tests;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("repeat")
public class RepeatedTesting {

    @Test
    @DisplayName("Test without repetition")
    void test_without_repetition(TestInfo testInfo){
        System.out.println("Executing: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod() + "||| Tags: ->  " + testInfo.getTags());
        assertTrue(true);
    }

    @RepeatedTest(value = 3, name = "{displayName} --> Repetition n° {currentRepetition} of {totalRepetitions}")
    void test_with_repetition(RepetitionInfo repetitionInfo, TestInfo testInfo){
        System.out.println("Current repetition: " + repetitionInfo.getCurrentRepetition() + " display or method: " + testInfo.getTestMethod().orElse(null).getName());
        assertTrue(true);
    }
}
