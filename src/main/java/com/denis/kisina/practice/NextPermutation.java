package com.denis.kisina.practice;

import java.util.Arrays;

public class NextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

    The replacement must be in place and use only constant extra memory.

    Example 1:

    Input: nums = [1,2,3]
    Output: [1,3,2]
    Example 2:

    Input: nums = [3,2,1]
    Output: [1,2,3]
    Example 3:

    Input: nums = [1,1,5]
    Output: [1,5,1]
    Example 4:

    Input: nums = [1]
    Output: [1]
     */

    public static void main(String[] args) {
        int[] example1 = {1,2,3};
        System.out.println(Arrays.toString(example1));
        System.out.println("-------------");
        nextPermutation(example1);
        System.out.println(Arrays.toString(example1));

        int[] example2 = {1,5,8,4,7,6,5,3,1};
        System.out.println(Arrays.toString(example2));
        System.out.println("-------------");
        nextPermutation(example2);
        System.out.println(Arrays.toString(example2));
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while(i >= 0 && (nums[i] <= nums[i-1])){
            i--;
        }

        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);

    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
