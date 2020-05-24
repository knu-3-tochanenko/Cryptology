package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class KaratsubaTest {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int BOUND = 128;
    private static final int ROUNDS = 16;

    @Test
    void zero() {
        assertEquals(
                BigInteger.ZERO,
                Karatsuba.multiply(BigInteger.valueOf(RANDOM.nextInt(BOUND) + 1), BigInteger.ZERO)
        );
        assertEquals(
                BigInteger.ZERO,
                Karatsuba.multiply(BigInteger.ZERO, BigInteger.valueOf(RANDOM.nextInt(BOUND) + 1))
        );
    }

    @Test
    void one() {
        BigInteger value = BigInteger.valueOf(RANDOM.nextInt(BOUND) + 1);
        assertEquals(
                value,
                Karatsuba.multiply(value, BigInteger.ONE)
        );
        assertEquals(
                value,
                Karatsuba.multiply(BigInteger.ONE, value)
        );
    }

    @Test
    void random() {
        for (int i = 0; i < ROUNDS; i++) {
            BigInteger a = BigInteger.valueOf(RANDOM.nextInt(BOUND) + 1);
            BigInteger b = BigInteger.valueOf(RANDOM.nextInt(BOUND) + 1);
            assertEquals(
                    a.multiply(b),
                    Karatsuba.multiply(a, b)
            );
        }
    }
}