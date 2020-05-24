package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryPowerTest {

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

            BigInteger number = BigIntegerUtils.random(
                    BigInteger.valueOf(Integer.MAX_VALUE),
                    BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                    System.currentTimeMillis()
            );

            BigInteger power = BigIntegerUtils.random(
                    BigInteger.valueOf(Integer.MAX_VALUE),
                    BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                    System.currentTimeMillis()
            );

            BigInteger mod = BigIntegerUtils.random(
                    BigInteger.valueOf(Integer.MAX_VALUE),
                    BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.TWO),
                    System.currentTimeMillis()
            );

            assertEquals(
                    number.modPow(power, mod),
                    BinaryPower.pow(number, power, mod)
            );
        }
    }
}