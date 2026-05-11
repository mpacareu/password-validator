package com.bskyb.quarks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();
    @Test
    public void correctPassword() {
        assertTrue(validator.isValid("Hola_567").fulfilled);
        assertTrue(validator.isValid("Nube_4AltaX").fulfilled);
        assertTrue(validator.isValid("Clave_9Segura").fulfilled);
        assertTrue(validator.isValid("Sol_2026Az").fulfilled);
    }

    @Test
    public void noPassword() {
        assertFalse(validator.isValid(" ").fulfilled);
    }
    @Test
    public void notEnoughCharacters(){
        assertFalse(validator.isValid("pepe_1A").fulfilled);
    }
    @Test
    public void noNumber(){
        assertFalse(validator.isValid("sinnumero_Aa").fulfilled);
    }
    @Test
    public void noLowerCase(){
        assertFalse(validator.isValid("SIN_123456").fulfilled);
    }
    @Test
    public void noCapitalLetter(){
        assertFalse(validator.isValid("claves_123ba").fulfilled);
    }
    @Test
    public void noUnderscore(){
        assertFalse(validator.isValid("clave123Aa").fulfilled);
    }
}