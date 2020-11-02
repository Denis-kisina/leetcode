package com.denis.kisina.practice.amazon.arrays_and_strings;

import java.util.*;

public class TwoSum {


    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

     */

    public int[] twoSum1(int[] nums, int target) {

        int i = 0, len = nums.length-2, sum = 0;
        int[] list = new int[2];

        while(i < len) {
            sum = nums[i] + nums[i + 1];
            if (sum == target) {
                list[0] = i;
                list[1] = i + 1;
            }
            i++;
        }
        return list;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), complement};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
