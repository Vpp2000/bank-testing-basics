package org.example.conditional_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OsTesting {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void test_for_windows(){
        assertTrue(true);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void test_for_linux(){
        assertTrue(true);
    }
}
