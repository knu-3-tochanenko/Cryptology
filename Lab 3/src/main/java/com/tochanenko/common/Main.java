package com.tochanenko.common;

import com.tochanenko.hash.Haval;
import static com.tochanenko.hash.HavalSpec.*;

public class Main {
    public static void main(String[] args) {
        Haval haval = new Haval(HAVAL_256_BIT, HAVAL_5_ROUND);
        String[] strings = {
                "Hello",
                "Henlo",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Integer et eros ultricies enim convallis mattis."
        };

        for (String string : strings) {
            System.out.println(string + " : " + haval.hash(string));
        }
    }
}
