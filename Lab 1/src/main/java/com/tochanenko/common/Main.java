package com.tochanenko.common;

import com.tochanenko.algo.FermatTest;

import java.math.BigInteger;


/*
[x]	Реализовать тест Ферма
[ ]	Реализовать тест Миллера - Рабина
[ ]	Реализовать операцию возведения по модулю в степень методом двоичного потенцирования
[ ]	Реализовать умножение Карацубы.
[ ]	Арифметика Монтгомери
[ ]	Расширенный алгоритм Евклида

Считать, что все числа в алгоритмах имеют длину не менее 512 бит.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI.Purple("It works!"));
        System.out.println(new FermatTest(10).test(BigInteger.valueOf(4)));
    }
}
