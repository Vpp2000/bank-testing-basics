package org.example.conditional_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JreTesting {

    @BeforeAll
    static void printProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + " =" + value));
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    public void test_for_java_11() {
        assertTrue(true);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    public void test_for_java_17() {
        assertTrue(true);
    }

    @Test
    @DisabledOnJre(JRE.JAVA_11)
    public void test_for_java_11_but_disabled() {
        assertTrue(true);
    }

    @Test
    @EnabledOnJre({JRE.JAVA_15, JRE.JAVA_11})
    public void test_for_java_15_or_11() {
        assertTrue(true);
    }
}
