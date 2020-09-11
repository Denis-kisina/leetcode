package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class RepeatedStringTest extends TestCase {

    RepeatedString repeatedString = new RepeatedString();

//    public void testRepeatedString() {
//        int expected = 7;
//
//        Assert.assertEquals(expected, repeatedString.repeatedString("aba", 10));
//
//    }
//
//    public void testRepeatedString2() {
//        long expected = 1000000000000l;
//
//        Assert.assertEquals(expected, repeatedString.repeatedString("a", 1000000000000l));
//
//    }

    public void testRepeatedString3() {
        long expected = 51574523448l;

        Assert.assertEquals(expected, repeatedString.repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400l));

    }
}