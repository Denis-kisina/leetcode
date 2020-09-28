package com.denis.kisina.practice.facebook.arraysandstrings;

import com.denis.kisina.practice.amazon.arraysandstrings.TwoSum;
import junit.framework.TestCase;

import java.util.Arrays;

public class TwoSumTest extends TestCase {
    /*
    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] ==

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]
     */
    TwoSum twoSum = new TwoSum();

    public void testTwoSum() {
        int[] input =  {2,7,11,15};
        int[] output = {0,1};
        int target = 9;
        Arrays.equals(output, twoSum.twoSum(input, target));

//        Assert.assertEquals(output, twoSum.twoSum(input, target));
    }

    public void testTwoSum1() {
        int[] input =  {3,2,4};
        int[] output = {1,2};
        int target = 6;
        Arrays.equals(output, twoSum.twoSum(input, target));

//        Assert.assertEquals(output, twoSum.twoSum(input, target));
    }

    public void testTwoSum2() {
        int[] input =  {3,3};
        int[] output = {0,1};
        int target = 6;
        Arrays.equals(output, twoSum.twoSum(input, target));

//        Assert.assertEquals(output, twoSum.twoSum(input, target));
    }
}