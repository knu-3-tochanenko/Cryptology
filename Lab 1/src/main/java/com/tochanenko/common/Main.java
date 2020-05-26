package com.tochanenko.common;

import com.tochanenko.algo.*;

import java.math.BigInteger;
import java.util.Arrays;


/*
[x]	Реализовать тест Ферма
[x]	Реализовать тест Миллера - Рабина
[x]	Реализовать операцию возведения по модулю в степень методом двоичного потенцирования
[x]	Реализовать умножение Карацубы.
[x]	Арифметика Монтгомери
[x]	Расширенный алгоритм Евклида

Считать, что все числа в алгоритмах имеют длину не менее 512 бит.
*/

public class Main {
    public static void main(String[] args) {

        // Fermat prime number test
        System.out.println(
                new Fermat(10).test(BigInteger.valueOf(7))
        );

        // Miller-Rabin prime number test
        System.out.println(
                new MillerRabin(10).test(BigInteger.valueOf(7))
        );

        // Binary power
        System.out.println(
                BinaryPower.pow(BigInteger.TWO, BigInteger.valueOf(5), BigInteger.valueOf(10000))
        );

        // Multiply two numbers using Karatsuba algorithm
        System.out.println(
                Karatsuba.multiply(BigInteger.TWO, BigInteger.valueOf(5))
        );

        // Montgomery algorithm to multiply and power by mod
        System.out.println(
                new Montgomery(BigInteger.valueOf(10000)).multiply(BigInteger.TWO, BigInteger.valueOf(5))
        );
        System.out.println(
                new Montgomery(BigInteger.valueOf(10000)).pow(BigInteger.TWO, BigInteger.valueOf(5))
        );

        // Extended Euclidean to find GCD and numbers to represent sum
        System.out.println(Arrays.toString(
                ExtendedEuclidean.compute(BigInteger.valueOf(17), BigInteger.valueOf(35))
        ));
    }
}
