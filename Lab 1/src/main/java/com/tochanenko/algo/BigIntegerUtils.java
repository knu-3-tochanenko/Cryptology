package com.tochanenko.algo;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerUtils {
    public static BigInteger random(BigInteger minLimit, BigInteger maxLimit, long seed) {
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        if (bigInteger.compareTo(BigInteger.ZERO) == 0) {
            return minLimit;
        }
        Random randNum = new Random(seed);
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0)
            res = res.add(minLimit);
        if (res.compareTo(bigInteger) >= 0)
            res = res.mod(bigInteger).add(minLimit);
        return res;
    }

    public static BigInteger pow(BigInteger number, BigInteger power) {
        if (power.compareTo(BigInteger.ZERO) == 0)
            return BigInteger.ONE;
        BigInteger res = number;
        BigInteger i = BigInteger.ONE;

        while (i.compareTo(power) < 0) {
            res = res.multiply(number);
            i = i.add(BigInteger.ONE);
        }

        return res;
    }
}
