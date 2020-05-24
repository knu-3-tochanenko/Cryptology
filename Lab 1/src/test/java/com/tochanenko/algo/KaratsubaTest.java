package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KaratsubaTest {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int BOUND = 128;
    private static final int ROUNDS = 16;

    @Test
    void zero() {
        assertEquals(
                BigInteger.ZERO,
                Karatsuba.multiply(
                        BigIntegerUtils.random(
                                BigInteger.valueOf(Integer.MAX_VALUE),
                                BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                                System.currentTimeMillis()
                        ),
                        BigInteger.ZERO
                ));
        assertEquals(
                BigInteger.ZERO,
                Karatsuba.multiply(BigInteger.ZERO, BigIntegerUtils.random(
                        BigInteger.valueOf(Integer.MAX_VALUE),
                        BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                        System.currentTimeMillis()
                )));
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
            BigInteger a = BigIntegerUtils.random(
                    BigInteger.valueOf(Integer.MAX_VALUE),
                    BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                    System.currentTimeMillis()
            );
            BigInteger b = BigIntegerUtils.random(
                    BigInteger.valueOf(Integer.MAX_VALUE),
                    BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                    System.currentTimeMillis()
            );
            assertEquals(
                    a.multiply(b),
                    Karatsuba.multiply(a, b)
            );
        }
    }
}