package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class SingleNumberTest extends TestCase {

    SingleNumber singleNumber = new SingleNumber();

    public void testSingleNumber() {
        int[] arr = {2,2,1};
        Assert.assertEquals(1, singleNumber.singleNumber(arr));
    }



    public void testSingleNumber1() {
        int[] arr ={4,1,2,1,2};
        Assert.assertEquals(4, singleNumber.singleNumber(arr));
    }
}