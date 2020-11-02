package com.denis.kisina.practice.amazon.arrays_and_strings;

import junit.framework.TestCase;
import org.junit.Assert;

public class RomanToIntTest extends TestCase {


    RomanToInt romanToInt = new RomanToInt();

    public void testRomanToInt() {

        Assert.assertEquals(3, romanToInt.romanToInt("III"));
    }
    public void testRomanToInt1() {

        Assert.assertEquals(4, romanToInt.romanToInt("IV"));
    }
    public void testRomanToInt2() {

        Assert.assertEquals(9, romanToInt.romanToInt("IX"));
    }
    public void testRomanToInt3() {
        Assert.assertEquals(58, romanToInt.romanToInt("LVIII"));
    }
    public void testRomanToInt4() {

        Assert.assertEquals(1994, romanToInt.romanToInt("MCMXCIV"));
    }

}