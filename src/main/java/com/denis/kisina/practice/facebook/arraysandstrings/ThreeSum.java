package com.denis.kisina.practice.facebook.arraysandstrings;

import java.util.*;

public class ThreeSum {

    /*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]

    Example 2:

    Input: nums = []
    Output: []

    Example 3:

    Input: nums = [0]
    Output: []

     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums==null || nums.length == 0 || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        threeSum(nums, result);
        return result;
    }
    private void threeSum(int[] nums, List<List<Integer>> result) {
       for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int j = i +1, k = nums.length - 1;
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> subset = new LinkedList<>();
                        subset.add(nums[i] );
                        subset.add(nums[i] );
                        subset.add(nums[i] );
                        result.add(subset);
                        while(j < k && nums[j] == nums[j+1]){j++;}
                        while(j < k && nums[k] == nums[k-1]){k--;}
                        j++; k--;
                    }else if(sum > 0){
                        k--;
                    }else {
                        j++;
                    }
                }
            }
       }
    }
}






















