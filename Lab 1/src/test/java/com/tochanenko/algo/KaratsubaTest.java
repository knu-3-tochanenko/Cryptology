package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KaratsubaTest {

    private static final int ROUNDS = 16;

    @Test
    void zero() {
        assertEquals(
                BigInteger.ZERO,
                Karatsuba.multiply(BigIntegerUtils.random(), BigInteger.ZERO)
        );
        assertEquals(
                BigInteger.ZERO,
                Karatsuba.multiply(BigInteger.ZERO, BigIntegerUtils.random())
        );
    }

    @Test
    void one() {
        BigInteger value = BigIntegerUtils.random(
                BigInteger.valueOf(Integer.MAX_VALUE),
                BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                System.currentTimeMillis()
        );
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
            BigInteger a = BigIntegerUtils.random();
            BigInteger b = BigIntegerUtils.random();
            assertEquals(
                    a.multiply(b),
                    Karatsuba.multiply(a, b)
            );
        }
    }
}