package Facade.Miscellaneous;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptAndDecryptTest {

    @Test
    public void testEncryptionOfCaracter() throws Exception {
        assertTrue(EncryptAndDecrypt.encrypt("a").equals("MfoJnt0hZRA="));
    }

    @Test
    public void testEncryptionOfNumber() throws Exception {
        assertTrue(EncryptAndDecrypt.encrypt("1").equals("b7JHqPF+Ca8="));
    }

    @Test
    public void testEncryptionOfSymbol() throws Exception {
        assertTrue(EncryptAndDecrypt.encrypt("@").equals("ZBjkYMMafDc="));
    }
}