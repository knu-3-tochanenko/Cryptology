package com.tochanenko.chipher;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XTEARandomKeyTest {

    private static final Random RANDOM = new Random(123456);

    @Test
    void withByteArray() {
        byte[] key = new byte[16];
        RANDOM.nextBytes(key);
        XTEA xtea = new XTEA(key);

        for (int i = 1; i < 17; i++) {
            byte[] bytes = new byte[i];
            for (int j = 0; j < i; j++)
                bytes[j] = randomCharacter();
            String string = new String(bytes);
            assertEquals(string, xtea.decrypt(xtea.encrypt(string)));
        }
    }

    @Test
    void withBase64() {
        byte[] key = new byte[16];
        RANDOM.nextBytes(key);
        XTEA xtea = new XTEA(key);

        for (int i = 1; i < 17; i++) {
            byte[] bytes = new byte[i];
            for (int j = 0; j < i; j++)
                bytes[j] = randomCharacter();
            String string = new String(bytes);
            assertEquals(string, xtea.decryptFromBase64(xtea.encryptToBase64(string)));
        }
    }

    private byte randomCharacter() {
        switch (RANDOM.nextInt(3)) {
            case 0:
                return (byte)(RANDOM.nextInt('z' - 'a') + 'a');
            case 1:
                return (byte)(RANDOM.nextInt('Z' - 'A') + 'A');
            case 2:
                return (byte)(RANDOM.nextInt('9' - '0') + '0');
        }
        return 0;
    }
}
