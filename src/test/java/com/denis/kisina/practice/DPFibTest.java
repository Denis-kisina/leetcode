package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DPFibTest extends TestCase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    DPFib dpFib = new DPFib();


    @Test
    public void test(){

        System.out.println("Number of test case " + this.countTestCases());

//        this.setName("first");

        System.out.println("updated test case name " + this.getName());

        Assert.assertEquals(1, dpFib.fib(1));
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}