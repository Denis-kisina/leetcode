package com.denis.kisina.practice.facebook.arraysandstrings;

/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]


    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

    algorithm:
    iterate through the array
    meet zero call shift


 */

import java.util.Arrays;

public class MoveZeroes {

    public int[] moveZeroes(int[] nums) {

        int len = nums.length, explorer = 0;
        int anchor = 0;

        while (explorer < len){
            if(nums[explorer] == 0){
                explorer++;
            }else{
                shift(explorer, nums, anchor, len );
                anchor++;
                explorer++;
            }
        }
        Arrays.stream(nums).forEach(e -> System.out.println(e));
        return nums;
    }

    private void shift(int explore, int[] nums, int anchor, int len) {
        int temp = nums[anchor];
        nums[anchor] = nums[explore];
        nums[explore] = temp;

    }

}
