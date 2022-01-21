package com.brightology.springsecurityjpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SecurityConfigurationTest {
    @Test
    void testGetPasswordEncoder() {
        assertTrue((new SecurityConfiguration())
                .getPasswordEncoder() instanceof org.springframework.security.crypto.password.NoOpPasswordEncoder);
    }
}

