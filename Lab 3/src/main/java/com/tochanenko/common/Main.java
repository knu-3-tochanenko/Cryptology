package com.tochanenko.common;

import com.tochanenko.hash.BaseHash;
import com.tochanenko.hash.Haval;
import com.tochanenko.hash.Util;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        Haval haval = new Haval(Haval.HAVAL_128_BIT, Haval.HAVAL_3_ROUND);
        String string = "Hollo";
        haval.update(string.getBytes(), 0, string.length());
        System.out.println(Util.toString(haval.digest()));
        haval.resetContext();
        string = "Hello";
        haval.update(string.getBytes(), 0, string.length());
        System.out.println(Util.toString(haval.digest()));

        haval.resetContext();
        string = "Mello";
        haval.update(string.getBytes(), 0, string.length());
        System.out.println(Util.toString(haval.digest()));

        haval.resetContext();
        string = "Nello";
        haval.update(string.getBytes(), 0, string.length());
        System.out.println(Util.toString(haval.digest()));
    }
}
