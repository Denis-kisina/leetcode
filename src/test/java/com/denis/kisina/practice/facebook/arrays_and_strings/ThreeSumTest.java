package com.denis.kisina.practice.facebook.arrays_and_strings;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.*;

public class ThreeSumTest extends TestCase {

    public void testThreeSum() {
        int[]  nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> l1 = List.of(-1,-1,2);
        List<Integer> l2 = List.of(-1,0,1);

        output.add(l1);
        output.add(l2);
        Assert.assertEquals(output, new ThreeSum().threeSum(nums));

    }
}