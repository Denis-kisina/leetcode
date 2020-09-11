package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CountingValleysTest extends TestCase {

    CountingValleys countingValleys = new CountingValleys();

    @Test
    public void test1(){
        int expected = 1;

        Assert.assertEquals(expected, countingValleys.countingValleys(8, "UDDDUDUU"));
    }

    @Test
    public void test2(){
        int expected = 2;

        Assert.assertEquals(expected, countingValleys.countingValleys(12, "DDUUDDUDUUUD"));
    }
}