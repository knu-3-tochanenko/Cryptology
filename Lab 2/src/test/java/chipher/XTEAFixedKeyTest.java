package chipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XTEAFixedKeyTest {

    private static final XTEA xtea = new XTEA("0123456789ABCDEF".getBytes());

    @Test
    void encrypt() {
        String[] toEncrypt = {
                "Hello",
                "Java",
                "i"
        };

        byte[][] expected = {
                new byte[]{0, 0, 0, 5, 16, 3, 100, 90, 120, 15, -114, 60},
                new byte[]{0, 0, 0, 4, -106, 53, -81, 42, 25, -74, 89, -89},
                new byte[]{0, 0, 0, 1, -35, 8, -45, -108, 80, 45, 40, 73}
        };

        for (int i = 0; i < Math.min(toEncrypt.length, expected.length); i++) {
            assertArrayEquals(expected[i], xtea.encrypt(toEncrypt[i]));
        }
    }

    @Test
    void decrypt() {
        byte[][] toDecrypt = {
                new byte[]{0, 0, 0, 5, 16, 3, 100, 90, 120, 15, -114, 60},
                new byte[]{0, 0, 0, 4, -106, 53, -81, 42, 25, -74, 89, -89},
                new byte[]{0, 0, 0, 1, -35, 8, -45, -108, 80, 45, 40, 73}
        };

        String[] decrypted = {
                "Hello",
                "Java",
                "i"
        };

        for (int i = 0; i < Math.min(toDecrypt.length, decrypted.length); i++) {
            assertEquals(decrypted[i], xtea.decrypt(toDecrypt[i]));
        }
    }

    @Test
    void decryptFromBase64() {
        String[] toDecrypt = {
                "AAAAHC1e0oOOz8yc0X8ohSbyxScvTXSIVk5ALoNlXLS+/lnE",
                "AAAAHHIaXFVa85WRDdq+B6fbV3RXIYzZR3gtPLxVOhFPzSb/",
                "AAAAAWc912iSbTdE",
                "AAAABNaKdvbk39XX",
                "AAAAeAObOqDqZojBs8P31piKSoI8smv/hr0KWaovRhGDl66j" +
                        "z8jPzyI5Wj3JAphIAkWowsVvpPZR0F63nB/EC8k+" +
                        "d6IxQHZv9xzKTvbzDQi1Rr7134C7RsFuw1c7pbV7" +
                        "YHqYn8TFl29wU9To5YaABHBcS67FsG32TCDpYg=="
        };

        String[] decrypted = {
                "Kotlin is the best language!",
                "Java Code convention. Do it!",
                "a",
                "2020",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Quisque ornare sagittis risus, ac tincidunt sapien commodo vel."
        };

        for (int i = 0; i < Math.min(toDecrypt.length, decrypted.length); i++) {
            assertEquals(decrypted[i], xtea.decryptFromBase64(toDecrypt[i]));
        }
    }

    @Test
    void encryptToBase64() {
        String[] toEncrypt = {
                "Kotlin is the best language!",
                "Java Code convention. Do it!",
                "a",
                "2020",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Quisque ornare sagittis risus, ac tincidunt sapien commodo vel."
        };

        String[] encrypted = {
                "AAAAHC1e0oOOz8yc0X8ohSbyxScvTXSIVk5ALoNlXLS+/lnE",
                "AAAAHHIaXFVa85WRDdq+B6fbV3RXIYzZR3gtPLxVOhFPzSb/",
                "AAAAAWc912iSbTdE",
                "AAAABNaKdvbk39XX",
                "AAAAeAObOqDqZojBs8P31piKSoI8smv/hr0KWaovRhGDl66j" +
                        "z8jPzyI5Wj3JAphIAkWowsVvpPZR0F63nB/EC8k+" +
                        "d6IxQHZv9xzKTvbzDQi1Rr7134C7RsFuw1c7pbV7" +
                        "YHqYn8TFl29wU9To5YaABHBcS67FsG32TCDpYg=="
        };

        for (int i = 0; i < Math.min(toEncrypt.length, encrypted.length); i++) {
            assertEquals(encrypted[i], xtea.encryptToBase64(toEncrypt[i]));
        }
    }
}