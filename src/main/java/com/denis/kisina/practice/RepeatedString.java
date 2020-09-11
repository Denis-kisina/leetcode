package com.denis.kisina.practice;

public class RepeatedString {

    public long repeatedString(String s, long n) {



        long whole = n / s.length();
        long remainder = n % s.length();

        int found = 0;

        for (char ch : s.toCharArray()
        ) {
            if (ch == 'a') {
                found++;
            }
        }
        long total = found * whole;

        if (remainder == 0) {
            return total;
        } else {
            for (char ch: s.substring(0, (int)remainder).toCharArray()
                 ) {
                if(ch == 'a'){
                    total++;
                }
            }
        }
        return total;
    }
}
