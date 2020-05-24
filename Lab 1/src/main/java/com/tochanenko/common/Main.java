package com.tochanenko.common;

import com.tochanenko.algo.Fermat;
import com.tochanenko.algo.MillerRabin;

import java.math.BigInteger;


/*
[x]	Реализовать тест Ферма
[x]	Реализовать тест Миллера - Рабина
[x]	Реализовать операцию возведения по модулю в степень методом двоичного потенцирования
[ ]	Реализовать умножение Карацубы.
[ ]	Арифметика Монтгомери
[ ]	Расширенный алгоритм Евклида

Считать, что все числа в алгоритмах имеют длину не менее 512 бит.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI.Purple("It works!"));
        System.out.println(new Fermat(10).test(BigInteger.valueOf(7)));
        System.out.println(new MillerRabin(10).test(BigInteger.valueOf(7)));
    }
}
