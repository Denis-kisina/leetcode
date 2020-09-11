package com.denis.kisina.practice;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {

        List<String> stringsArray = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {

                addToArray("FizzBuzz", stringsArray);
            } else if (i % 3 == 0) {
                addToArray("Fizz", stringsArray);
            } else if (i % 5 == 0) {
                addToArray("Buzz", stringsArray);
            } else {
                addToArray("" + i, stringsArray);
            }

        }
        return stringsArray;
    }

    private void addToArray(String expression, List<String> stringsArray) {
        stringsArray.add(expression);
    }
}

