package com.tochanenko.common;

import com.tochanenko.chipher.XTEA;

public class Main {
    public static void main(String[] args) {
        String toEncrypt = "Something awesome";
        String key = "0123456789ABCDEF";

        XTEA xtea = new XTEA(key.getBytes());

        System.out.println(xtea.decryptFromBase64(xtea.encryptToBase64(toEncrypt)));
    }
}
