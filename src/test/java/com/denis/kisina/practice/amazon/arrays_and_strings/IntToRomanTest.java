package com.denis.kisina.practice.amazon.arrays_and_strings;

import junit.framework.TestCase;
import org.junit.Assert;

public class IntToRomanTest extends TestCase {

    IntToRoman intToRoman = new IntToRoman();

    public void testIntToRoman() {
        /*
         Example 1:
         Input: 3
        Output: "III"
         */
        Assert.assertEquals("III", intToRoman.intToRoman(3));
    }

    public void testIntToRoman2() {

        Assert.assertEquals("IV", intToRoman.intToRoman(4));
    }

    public void testIntToRoman3() {

        Assert.assertEquals("IX", intToRoman.intToRoman(9));
    }


    public void testIntToRoman4() {

        Assert.assertEquals("LVIII", intToRoman.intToRoman(58));
    }

    /*
    input: 1994
    Output: "MCMXCIV"
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
     */
    public void testIntToRoman5() {

        Assert.assertEquals("MCMXCIV", intToRoman.intToRoman(1994));
    }

}