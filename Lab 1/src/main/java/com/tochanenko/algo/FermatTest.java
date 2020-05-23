package com.tochanenko.algo;

import java.math.BigInteger;

import static com.tochanenko.algo.BigIntegerUtils.pow;
import static com.tochanenko.algo.BigIntegerUtils.random;

public class FermatTest {
    private final int k;
    private final long seed;

    public FermatTest(int k) {
        this.k = k;
        this.seed = System.currentTimeMillis();
    }

    public FermatTest(int k, long seed) {
        this.k = k;
        this.seed = seed;
    }

    public boolean test(BigInteger number) {
        if (number.compareTo(BigInteger.valueOf(4)) < 0)
            throw new IllegalArgumentException("Number should be greater then 3");

        BigInteger aInPower, randomValue;
        BigInteger numberMinusOne = number.subtract(BigInteger.ONE);
        BigInteger numberMinusTwo = number.subtract(BigInteger.TWO);

        for (int i = 0; i < this.k; i++) {
            randomValue = random(BigInteger.TWO, numberMinusTwo, seed);
            aInPower = pow(randomValue, numberMinusOne);
            if (aInPower.mod(number).compareTo(BigInteger.ONE) != 0)
                return false;
        }
        return true;
    }
}
