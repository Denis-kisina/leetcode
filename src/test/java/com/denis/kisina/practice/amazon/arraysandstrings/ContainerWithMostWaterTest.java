package com.denis.kisina.practice.amazon.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Assert;

public class ContainerWithMostWaterTest extends TestCase {

    ContainerWithMostWater container = new ContainerWithMostWater();

    public void testMaxArea() {

        /*
        Input: [1,8,6,2,5,4,8,3,7]
        Output: 49
         */
        int[] input = new int[] {1,8,6,2,5,4,8,3,7};
        int output = 49;

        Assert.assertEquals(output, container.maxArea(input));
    }
}