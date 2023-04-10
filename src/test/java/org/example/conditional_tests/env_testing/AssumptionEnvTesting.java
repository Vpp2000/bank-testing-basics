package org.example.conditional_tests.env_testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionEnvTesting {
    @Test
    @DisplayName("Assumption based on system property")
    void test_based_on_system_property(){
        boolean isSysPropDev = "prod".equals(System.getProperty("ENV"));
         // assumeTrue(isSysPropDev); esto invalida todo el test

        assumingThat(isSysPropDev, () -> {   // sirve para skipear o no un blo de aserciones
            System.out.println("env: " + System.getProperty("ENV") + " isSysPropDev: " + isSysPropDev);
            assertTrue(true);
            assertTrue(true);
        });

        assertTrue(true);
        assertTrue(true);

    }

    @Test
    void test_anything(){
        assertTrue(true);
    }
}
