package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class LengthOfLongestSubstringTest extends TestCase {

    LengthOfLongestSubstring l = new LengthOfLongestSubstring();


    public void testLengthOfLongestSubstring() {
        Assert.assertEquals(3, l.lengthOfLongestSubstring("abcabcbb"));
    }

    public void testLengthOfLongestSubstring1() {
        Assert.assertEquals(2, l.lengthOfLongestSubstring("aab"));
    }



    public void testLengthOfLongestSubstring2() {
        Assert.assertEquals(2, l.lengthOfLongestSubstring("au"));
    }

    public void testLengthOfLongestSubstring3() {
        Assert.assertEquals(1, l.lengthOfLongestSubstring("bbbbb"));
    }

    public void testLengthOfLongestSubstring4() {
        Assert.assertEquals(3, l.lengthOfLongestSubstring("dvdf"));
    }


}