package org.example.conditional_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OsTesting {
    private TestInfo testInfo;
    private TestReporter testReporter;


    @BeforeEach
    void setup(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void test_for_windows(){
        assertTrue(true);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Testing for linux")
    void test_for_linux(){
        testReporter.publishEntry("executing " + testInfo.getDisplayName() + " on method " + testInfo.getTestMethod());
        assertTrue(true);
    }
}
