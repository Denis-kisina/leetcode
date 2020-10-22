package com.denis.kisina.practice;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class MatchingPairs {

    // Add any helper functions you may need here


    int matchingPairs(String s, String t) {
        // Write your code here

        if (s.equals(t)) {
            return s.length() - 2;
        }
        int matching = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (ch1 != ch2) {
                set.add(ch1 + "" + ch2);
            } else {
                matching++;
            }
        }

        for (String pair : set) {
            String reversed = pair.charAt(1) + "" + pair.charAt(0);
            if (set.contains(reversed)) {
                matching = matching + 1;
            }
        }

        return matching;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

        String s_3 = "mno", t_3 = "mno";
        int expected_3 = 1;
        int output_3 = matchingPairs(s_3, t_3);
        check(expected_3, output_3);


        String s_4 = "abcd", t_4 = "efgh";
        int expected_4 = 0;
        int output_4 = matchingPairs(s_4, t_4);
        check(expected_4, output_4);
    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
