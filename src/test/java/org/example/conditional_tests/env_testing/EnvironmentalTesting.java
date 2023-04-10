package org.example.conditional_tests.env_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnvironmentalTesting {
    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void test_if_env_is_dev() {
        assertTrue(true);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SHELL", matches = "/bin/bash")
    void test_if_shell_is_bash(){
        Map<String, String> getEnvVars = System.getenv();
        getEnvVars.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "STAGE", matches = "prod")
    void test_if_stage_is_prod(){
        assertTrue(true);
    }
}
