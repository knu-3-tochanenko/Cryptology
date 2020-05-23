package com.tochanenko.algo;

import java.math.BigInteger;
import java.util.Random;

public class FermatTest {
    private final int k;
    private final Random random;

    public FermatTest(int k) {
        this.k = k;
        this.random = new Random(System.currentTimeMillis());
    }

    public FermatTest(int k, long seed) {
        this.k = k;
        this.random = new Random(seed);
    }

    public boolean test(int number) {
        if (number < 4)
            throw new IllegalArgumentException("Number should be greater then 3");

        BigInteger aInN;
        BigInteger mod = BigInteger.valueOf(number);
        int randomValue;

        for (int i = 0; i < this.k; i++) {
            randomValue = random.nextInt(number - 3) + 2;
            aInN = pow(randomValue, number - 1);
            if (aInN.mod(mod).compareTo(BigInteger.ONE) != 0)
                return false;
        }
        return true;
    }

    private BigInteger pow(int number, int power) {
        BigInteger res = BigInteger.valueOf(number);
        BigInteger toMultiply = BigInteger.valueOf(number);
        for (int i = 1; i < power; i++)
            res = res.multiply(toMultiply);
        return res;
    }
}
