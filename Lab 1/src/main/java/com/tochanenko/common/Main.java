package com.tochanenko.common;

import com.tochanenko.algo.FermatTest;


/*
1.	Реализовать тест Ферма
2.	Реализовать тест Миллера - Рабина
3.	Реализовать операцию возведения по модулю в степень методом двоичного потенцирования
4.	Реализовать умножение Карацубы.
5.	Арифметика Монтгомери
6.	Расширенный алгоритм Евклида

Считать, что все числа в алгоритмах имеют длину не менее 512 бит.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI.Purple("It works!"));

        System.out.println(new FermatTest(10).test(4));
    }
}
