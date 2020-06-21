package com.tochanenko.chipher;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XTEAGeneralTest {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final XTEA XTEA_FIXED_KEY = new XTEA("0123456789ABCDEF".getBytes());

    @Test
    void encrypt() {
        assertThrows(IllegalArgumentException.class, () -> XTEA_FIXED_KEY.encrypt(""));
        assertThrows(IllegalArgumentException.class, () -> XTEA_FIXED_KEY.encrypt(null));
    }

    @Test
    void decrypt() {
        assertThrows(AssertionError.class, () -> XTEA_FIXED_KEY.decrypt(new byte[]{}));
        assertThrows(AssertionError.class, () -> XTEA_FIXED_KEY.decrypt(new byte[]{0}));
        assertThrows(AssertionError.class, () -> XTEA_FIXED_KEY.decrypt(new byte[]{0, 0}));
        assertThrows(AssertionError.class, () -> XTEA_FIXED_KEY.decrypt(new byte[]{0, 0, 0, 0, 0}));
    }

    @Test
    void wrongKey() {
        assertThrows(IllegalArgumentException.class, () -> new XTEA(null));

        for (int i = 1; i < 16; i++) {
            byte[] key = new byte[i];
            RANDOM.nextBytes(key);
            assertThrows(IllegalArgumentException.class, () -> new XTEA(key));
        }

        byte[] key = new byte[16];
        RANDOM.nextBytes(key);
        assertDoesNotThrow(() -> new XTEA(key));

        byte[] bigKey = new byte[17];
        RANDOM.nextBytes(bigKey);
        assertThrows(IllegalArgumentException.class, () -> new XTEA(bigKey));
    }

    @Test
    void decryptFromBase64() {
        assertThrows(IllegalArgumentException.class, () -> XTEA_FIXED_KEY.decryptFromBase64(""));
        assertThrows(IllegalArgumentException.class, () -> XTEA_FIXED_KEY.decryptFromBase64(null));
    }

    @Test
    void encryptToBase64() {
        assertThrows(IllegalArgumentException.class, () -> XTEA_FIXED_KEY.encryptToBase64(""));
        assertThrows(IllegalArgumentException.class, () -> XTEA_FIXED_KEY.encryptToBase64(null));
    }
}
