package chipher;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XTEARandomKeyTest {

    private static final Random random = new Random(123456);

    @Test
    void withByteArray() {
        byte[] key = new byte[16];
        random.nextBytes(key);
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
        random.nextBytes(key);
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
        switch (random.nextInt(3)) {
            case 0:
                return (byte)(random.nextInt('z' - 'a') + 'a');
            case 1:
                return (byte)(random.nextInt('Z' - 'A') + 'A');
            case 2:
                return (byte)(random.nextInt('9' - '0') + '0');
        }
        return 0;
    }
}
