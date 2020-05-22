package chipher;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XTEAGeneralTest {

    private static final Random random = new Random(System.currentTimeMillis());
    private static final XTEA xtea = new XTEA("0123456789ABCDEF".getBytes());

    @Test
    void encrypt() {
        assertThrows(IllegalArgumentException.class, () -> xtea.encrypt(""));
        assertThrows(IllegalArgumentException.class, () -> xtea.encrypt(null));
    }

    @Test
    void decrypt() {
        assertThrows(AssertionError.class, () -> xtea.decrypt(new byte[]{}));
        assertThrows(AssertionError.class, () -> xtea.decrypt(new byte[]{0}));
        assertThrows(AssertionError.class, () -> xtea.decrypt(new byte[]{0, 0}));
        assertThrows(AssertionError.class, () -> xtea.decrypt(new byte[]{0, 0, 0, 0, 0}));
    }

    @Test
    void wrongKey() {
        assertThrows(IllegalArgumentException.class, () -> new XTEA(null));

        for (int i = 1; i < 16; i++) {
            byte[] key = new byte[i];
            random.nextBytes(key);
            assertThrows(IllegalArgumentException.class, () -> new XTEA(key));
        }

        byte[] key = new byte[16];
        random.nextBytes(key);
        assertDoesNotThrow(() -> new XTEA(key));

        byte[] bigKey = new byte[17];
        random.nextBytes(bigKey);
        assertThrows(IllegalArgumentException.class, () -> new XTEA(bigKey));
    }

    @Test
    void decryptFromBase64() {
        assertThrows(IllegalArgumentException.class, () -> xtea.decryptFromBase64(""));
        assertThrows(IllegalArgumentException.class, () -> xtea.decryptFromBase64(null));
    }

    @Test
    void encryptToBase64() {
        assertThrows(IllegalArgumentException.class, () -> xtea.encryptToBase64(""));
        assertThrows(IllegalArgumentException.class, () -> xtea.encryptToBase64(null));
    }
}
