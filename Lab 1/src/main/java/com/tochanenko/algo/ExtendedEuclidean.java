package com.tochanenko.algo;

import java.math.BigInteger;

public class ExtendedEuclidean {
    public static BigInteger[] compute(BigInteger a, BigInteger b) {
        BigInteger[] result = new BigInteger[3];
        if (a.equals(BigInteger.ZERO)) {
            result[0] = b;
            result[1] = BigInteger.ZERO;
            result[2] = BigInteger.ONE;
        } else {
            BigInteger[] previousResult = compute(b.mod(a), a);
            result[0] = previousResult[0];
            result[1] = previousResult[2].subtract(b.divide(a).multiply(previousResult[1]));
            result[2] = previousResult[1];
        }
        return result;
    }
}
