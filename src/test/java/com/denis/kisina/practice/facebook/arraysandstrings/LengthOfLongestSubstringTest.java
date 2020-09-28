package com.denis.kisina.practice.facebook.arraysandstrings;

import com.denis.kisina.practice.amazon.arraysandstrings.LengthOfLongestSubstring;
import junit.framework.TestCase;
import org.junit.Assert;

public class LengthOfLongestSubstringTest extends TestCase {

    LengthOfLongestSubstring substring = new LengthOfLongestSubstring();

    public void testLengthOfLongestSubstring() {
        String input = "abcabcbb";

        Assert.assertEquals(3, substring.LengthOfLongestSubstring(input));
    }

    public void testLengthOfLongestSubstring1() {
        String input = "bbbbb";

        Assert.assertEquals(1, substring.LengthOfLongestSubstring(input));
    }

    public void testLengthOfLongestSubstring2() {
        String input = "pwwkew";

        Assert.assertEquals(3, substring.LengthOfLongestSubstring(input));
    }
}