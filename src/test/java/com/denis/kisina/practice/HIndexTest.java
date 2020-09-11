package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class HIndexTest extends TestCase {

    HIndex hIndex = new HIndex();

    @Test
    public void testHIndex() {
        int expected = 3;
        int[] citations = {3,0,6,1,5};

        Assert.assertEquals(expected, hIndex.hIndex(citations));
    }

    @Test
    public void testOne(){
        int expected = 1;
        int[] citations = {1};

        Assert.assertEquals(expected, hIndex.hIndex(citations));
    }

    @Test
    public void testZero(){
        int expected = 0;
        int[] citations = {0};

        Assert.assertEquals(expected, hIndex.hIndex(citations));
    }

    @Test
    public void testThree(){
        int expected = 1;
        int[] citations = {0,1};

        Assert.assertEquals(expected, hIndex.hIndex(citations));
    }
}