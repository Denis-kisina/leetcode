package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestPalindromeTest extends TestCase {

    /*
    *
    * Input: "babad"
Output: "bab"
    *
    * */

    LongestPalindrome l = new LongestPalindrome();

    public void testLongestPalindrome() {
        Assert.assertEquals("bab", l.longestPalindrome("babad"));
    }


    public void testLongestPalindrome1() {
        Assert.assertEquals("ccc", l.longestPalindrome("ccc"));
    }
}