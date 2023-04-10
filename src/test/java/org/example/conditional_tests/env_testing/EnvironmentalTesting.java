package org.example.conditional_tests.env_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnvironmentalTesting {
    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void test_if_env_is_dev() {
        assertTrue(true);
    }
}
