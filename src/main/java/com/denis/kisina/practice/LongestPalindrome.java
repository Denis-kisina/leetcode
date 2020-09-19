package com.denis.kisina.practice;

public class LongestPalindrome {

    int resultStart;
    int resultLength;

    public String longestPalindrome(String s) {
        int strLength = s.length();

        if (strLength < 2) {
            return s;
        }
        for (int begin = 0; begin < strLength-1; begin++) {
            expandOut(s, begin, begin);
            expandOut(s, begin, begin + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandOut(String s, int begin, int end) {

        int strLength = s.length();

        while (begin >= 0 && end <= strLength-1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;

        }

        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;

        }
    }
}
