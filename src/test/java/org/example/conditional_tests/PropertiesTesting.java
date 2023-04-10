package org.example.conditional_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropertiesTesting {
    @Test
    @EnabledIfSystemProperty(named = "os.name", matches = "Linux")  // you could use a regex in matches
    void test_for_linux() {
        assertTrue(true);
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*amd.*")
    void test_for_amd() {
        assertTrue(true);
    }

}
