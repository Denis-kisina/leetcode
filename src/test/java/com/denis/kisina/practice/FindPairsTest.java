package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class FindPairsTest extends TestCase {

    FindPairs findPairs = new FindPairs();

    public void testFindPairs() {
        int[] arr = {3, 1, 4, 1, 5}; int k = 2; int expected =  2;

        Assert.assertEquals(expected, findPairs.findPairs(arr, k));
    }



    public void testFindPairs1() {
        int[] arr = {1,2,3,4,5}; int k = 1; int expected =  4;

        Assert.assertEquals(expected, findPairs.findPairs(arr, k));
    }



    public void testFindPairs2() {
        int[] arr = {1,1,1,2,1}; int k = 1; int expected =  1;

        Assert.assertEquals(expected, findPairs.findPairs(arr, k));
    }



    public void testFindPairs3() {
        int[] arr = {1,3,1,5,4}; int k = 0; int expected =  1;

        Assert.assertEquals(expected, findPairs.findPairs(arr, k));
    }

}