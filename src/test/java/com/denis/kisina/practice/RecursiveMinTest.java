package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class RecursiveMinTest extends TestCase {

    RecursiveMin recursiveMin = new RecursiveMin();

    public void testRmin() {
        Assert.assertEquals("a", recursiveMin.rmin("abdefsd"));
    }
}