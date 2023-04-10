package org.example.timeouts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeOutTesting {
    @Test
    @DisplayName("Test with simple timeout in seconds")
    @Timeout(2)
    public void test_simple_timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        assertTrue(false);
    }

    @Test
    @DisplayName("Test with sofisticated timeout annotation")
    @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
    void test_sofisticated_timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        assertTrue(true);
    }

    @Test
    @DisplayName("Test with lambda assertion timeout")
    void test_lambda_timeout(){
        assertTimeout(Duration.ofSeconds(2L), () -> {
            TimeUnit.SECONDS.sleep(1);
        });
    }


}
