package Facade.Miscellaneous;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptAndDecryptTest {

    @Test
    public void testEncryptionOfCharacter() throws Exception {
        assertTrue(EncryptAndDecrypt.encrypt("abcdefgh").equals("jsTW+A0ZbPl5PGZ5FGKGsA=="));
    }

    @Test
    public void testEncryptionOfNumber() throws Exception {
        assertTrue(EncryptAndDecrypt.encrypt("12345678").equals("0KkUlh8bVyXKtO22oZHC0Q=="));
    }

    @Test
    public void testEncryptionOfSymbol() throws Exception {
        assertTrue(EncryptAndDecrypt.encrypt("!@#$%^&*").equals("Nk7wQxRfTzMAApQDepr/NA=="));
    }
}