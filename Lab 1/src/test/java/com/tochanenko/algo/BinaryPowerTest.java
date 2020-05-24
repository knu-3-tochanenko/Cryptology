package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryPowerTest {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int BOUND = 5;
    private static final int ROUNDS = 16;

    @Test
    void zero() {
        assertEquals(
                BigInteger.ONE,
                BinaryPower.pow(BigInteger.TWO, BigInteger.ZERO, BigInteger.TWO)
        );
    }

    @Test
    void one() {
        assertEquals(
                BigInteger.valueOf(4),
                BinaryPower.pow(BigInteger.valueOf(4), BigInteger.ONE, BigInteger.valueOf(5))
        );
    }

    @Test
    void random() {
        for (int i = 0; i < ROUNDS; i++) {
            int number = RANDOM.nextInt(BOUND) + 4;
            int power = RANDOM.nextInt(BOUND) + 4;
            int mod = RANDOM.nextInt(BOUND) + 4;

            assertEquals(
                    BigInteger.valueOf(testPow(number, power, mod)),
                    BinaryPower.pow(BigInteger.valueOf(number), BigInteger.valueOf(power), BigInteger.valueOf(mod))
            );
        }
    }

    private int testPow(int number, int power, int mod) {
        return ((int)Math.pow(number, power)) % mod;
    }
}