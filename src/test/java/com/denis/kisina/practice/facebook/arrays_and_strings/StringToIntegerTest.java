package com.denis.kisina.practice.facebook.arrays_and_strings;

import com.denis.kisina.practice.amazon.arrays_and_strings.StringToInteger;
import junit.framework.TestCase;
import org.junit.Assert;

public class StringToIntegerTest extends TestCase {

    StringToInteger stringToInteger = new StringToInteger();

    public void testMyAtoi() {
        String input = "42";
        int output = 42;
        Assert.assertEquals(output, stringToInteger.myAtoi(input));
    }

    public void testMyAtoi1() {
        String input = "   -42";
        int output = -42;
        Assert.assertEquals(output, stringToInteger.myAtoi(input));
    }

    public void testMyAtoi2() {
        String input = "4193with words";
        int output = 4193;
        Assert.assertEquals(output, stringToInteger.myAtoi(input));
    }



    public void testMyAtoi3() {
        String input = "words and 987";
        int output = 0;
        Assert.assertEquals(output, stringToInteger.myAtoi(input));
    }

    public void testMyAtoi4() {
        String input = "-91283472332";
        int output = -2147483648;
        Assert.assertEquals(output, stringToInteger.myAtoi(input));
    }
}