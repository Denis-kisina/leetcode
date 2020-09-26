package com.denis.kisina.practice.facebook.arraysandstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringToInteger {

    /*
    Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

    Example 1:

    Input: "42"
    Output: 42
    Example 2:

    Input: "   -42"
    Output: -42
    Explanation: The first non-whitespace character is '-', which is the minus sign.
                 Then take as many numerical digits as possible, which gets 42.
    Example 3:

    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
    Example 4:

    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.
    Example 5:

    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 Thefore INT_MIN (−231) is returned.
     */

    public int myAtoi(String str) {
        String newString;

        //remove white spaces
        newString = str.strip();

        int result = 0;
        int sign = 1;
        int i = 0;
        int MAX_INT = Integer.MAX_VALUE;
        int MIN_INT = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        // check and set the negative / positive sign
        if (newString.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (newString.charAt(0) == '+') {
            i++;
        } else {
            i = 0;
        }

        //chek number and build it up
        while (i < newString.length() && set.contains(newString.charAt(i))) {
            // check max number
            if (result > MAX_INT / 10) {
                return (sign == 1)?MAX_INT:MIN_INT;
            }
            result = result * 10 + Integer.parseInt(String.valueOf(newString.charAt(i++)));
        }
        result = result * sign;

        return result;
    }
}
