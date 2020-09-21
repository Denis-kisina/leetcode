package com.denis.kisina.practice;


import junit.framework.TestCase;
import org.junit.Assert;

public class ReverseStringRecursiveTest extends TestCase {

    ReverseStringRecursive reverseStringRecursive = new ReverseStringRecursive();

    public void testReverse() {
        Assert.assertEquals("eht", reverseStringRecursive.reverse("the"));
    }
}