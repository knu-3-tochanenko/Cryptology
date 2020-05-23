package com.tochanenko.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FermatTestTest {
    private static final FermatTest RANDOM_SEED = new FermatTest(64);
    private static final FermatTest FIXED_SEED_LOW = new FermatTest(8, 12345);
    private static final FermatTest FIXED_SEED_HIGH = new FermatTest(64, 12345);

    @Test
    void testIllegalArguments() {
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(-1));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(0));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(1));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(2));
        assertThrows(IllegalArgumentException.class, () -> RANDOM_SEED.test(3));
        assertDoesNotThrow(() -> RANDOM_SEED.test(4));
    }

    @Test
    void testLow() {
        assertFalse(FIXED_SEED_LOW.test(4));
        assertFalse(FIXED_SEED_LOW.test(16));
        assertFalse(FIXED_SEED_LOW.test(10025));

        assertTrue(FIXED_SEED_LOW.test(5));
        assertTrue(FIXED_SEED_LOW.test(17));
        assertTrue(FIXED_SEED_LOW.test(5));
    }
}