package com.bskyb.quarks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PasswordValidatorTest {

    @Test
    public void correctPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("Hola_567"));
        assertTrue(validator.isValid("Nube_4AltaX"));
        assertTrue(validator.isValid("Clave_9Segura"));
        assertTrue(validator.isValid("Sol_2026Az"));
    }
    @Test
    public void wrongPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("pepe_1A"));
        assertFalse(validator.isValid("sinnumero_Aa"));
        assertFalse(validator.isValid("SIN_123456"));
        assertFalse(validator.isValid("clave123Aa"));
        assertFalse(validator.isValid(" "));

    }

}