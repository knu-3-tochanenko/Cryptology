package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static com.tochanenko.algo.BigIntegerUtils.pow;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class MillerRabinTest {

    private static final MillerRabin RANDOM_SEED = new MillerRabin(64);
    private static final MillerRabin FIXED_SEED_LOW = new MillerRabin(8, 12345);
    private static final MillerRabin FIXED_SEED_HIGH = new MillerRabin(64, 12345);

    @Test
    void testIllegalArguments() {
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(BigInteger.valueOf(-1)));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(BigInteger.valueOf(0)));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(BigInteger.valueOf(1)));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(BigInteger.valueOf(2)));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(BigInteger.valueOf(3)));
        assertDoesNotThrow(() -> RANDOM_SEED.test(BigInteger.valueOf(4)));
    }

    @Test
    void testLow() {
        assertFalse(FIXED_SEED_LOW.test(BigInteger.valueOf(4)));
        assertFalse(FIXED_SEED_LOW.test(BigInteger.valueOf(16)));
        assertFalse(FIXED_SEED_LOW.test(BigInteger.valueOf(10025)));
        assertFalse(FIXED_SEED_LOW.test(BigInteger.valueOf(2147483646)));

        assertTrue(FIXED_SEED_LOW.test(BigInteger.valueOf(5)));
        assertTrue(FIXED_SEED_LOW.test(BigInteger.valueOf(17)));
    }

    @Test
    void testHigh() {
        assertFalse(FIXED_SEED_HIGH.test(BigInteger.valueOf(4)));
        assertFalse(FIXED_SEED_HIGH.test(BigInteger.valueOf(16)));
        assertFalse(FIXED_SEED_HIGH.test(BigInteger.valueOf(10025)));
        assertFalse(FIXED_SEED_HIGH.test(pow(BigInteger.valueOf(64), BigInteger.TWO)));

        assertTrue(FIXED_SEED_HIGH.test(BigInteger.valueOf(5)));
        assertTrue(FIXED_SEED_HIGH.test(BigInteger.valueOf(17)));
        assertTrue(FIXED_SEED_HIGH.test(BigInteger.valueOf(2147483647).add(BigInteger.valueOf(12))));
    }
}