package com.tochanenko.chipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XTEAFixedKeyTest {

    private static final XTEA XTEA_FIXED_KEY = new XTEA("0123456789ABCDEF".getBytes());

    private static final String[] SMALL_STRINGS = {
            "Hello",
            "Java",
            "i"
    };

    private static final byte[][] ENCRYPTED_BYTES = {
            new byte[]{0, 0, 0, 5, 16, 3, 100, 90, 120, 15, -114, 60},
            new byte[]{0, 0, 0, 4, -106, 53, -81, 42, 25, -74, 89, -89},
            new byte[]{0, 0, 0, 1, -35, 8, -45, -108, 80, 45, 40, 73}
    };

    private static final String[] STRINGS = {
            "Kotlin is the best language!",
            "Java Code convention. Do it!",
            "a",
            "2020",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Quisque ornare sagittis risus, ac tincidunt sapien commodo vel."
    };

    private static final String[] IN_BASE_64 = {
            "AAAAHC1e0oOOz8yc0X8ohSbyxScvTXSIVk5ALoNlXLS+/lnE",
            "AAAAHHIaXFVa85WRDdq+B6fbV3RXIYzZR3gtPLxVOhFPzSb/",
            "AAAAAWc912iSbTdE",
            "AAAABNaKdvbk39XX",
            "AAAAeAObOqDqZojBs8P31piKSoI8smv/hr0KWaovRhGDl66j" +
                    "z8jPzyI5Wj3JAphIAkWowsVvpPZR0F63nB/EC8k+" +
                    "d6IxQHZv9xzKTvbzDQi1Rr7134C7RsFuw1c7pbV7" +
                    "YHqYn8TFl29wU9To5YaABHBcS67FsG32TCDpYg=="
    };

    @Test
    void encrypt() {
        for (int i = 0; i < Math.min(SMALL_STRINGS.length, ENCRYPTED_BYTES.length); i++) {
            assertArrayEquals(ENCRYPTED_BYTES[i], XTEA_FIXED_KEY.encrypt(SMALL_STRINGS[i]));
        }
    }

    @Test
    void decrypt() {
        for (int i = 0; i < Math.min(ENCRYPTED_BYTES.length, SMALL_STRINGS.length); i++) {
            assertEquals(SMALL_STRINGS[i], XTEA_FIXED_KEY.decrypt(ENCRYPTED_BYTES[i]));
        }
    }

    @Test
    void decryptFromBase64() {
        for (int i = 0; i < Math.min(IN_BASE_64.length, STRINGS.length); i++) {
            assertEquals(STRINGS[i], XTEA_FIXED_KEY.decryptFromBase64(IN_BASE_64[i]));
        }
    }

    @Test
    void encryptToBase64() {
        for (int i = 0; i < Math.min(STRINGS.length, IN_BASE_64.length); i++) {
            assertEquals(IN_BASE_64[i], XTEA_FIXED_KEY.encryptToBase64(STRINGS[i]));
        }
    }
}