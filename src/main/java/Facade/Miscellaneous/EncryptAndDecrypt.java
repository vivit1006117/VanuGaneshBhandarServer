package Facade.Miscellaneous;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;


import java.security.spec.KeySpec;

public class EncryptAndDecrypt {
    private static final String UNICODE_FORMAT = "UTF8";
    private static Cipher cipher;
    private static SecretKey key;

    private static void EncryptAndDecryptParams(String unencryptedString) throws Exception {
        String dynamicContent = unencryptedString.substring(2, 7);
        String myEncryptionKey = dynamicContent + "UnitedWeAreOne" + dynamicContent;
        String DESEDE_ENCRYPTION_SCHEME = "DESede";
        byte[] arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        KeySpec ks = new DESedeKeySpec(arrayBytes);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
        cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
        key = skf.generateSecret(ks);
    }

    public static String encrypt(String unencryptedString) throws Exception {
        EncryptAndDecryptParams(unencryptedString);
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
}
