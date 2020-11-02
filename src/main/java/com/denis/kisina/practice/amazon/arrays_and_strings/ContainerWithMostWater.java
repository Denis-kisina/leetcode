package com.denis.kisina.practice.amazon.arrays_and_strings;

public class ContainerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.

    https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg
     */


    /*
    runtime is O(n^2)
     */
    public int maxArea1(int[] height) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min*(j-i));
            }
        }

        return max;

    }
    /*
    O(n)
     */

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while( i  < j){
          int min = Math.min(height[i], height[j]);
          max = Math.max(max, min*(j-i));
          if(height[i] < height[j]){
              i++;
          }else{
              j--;
          }
        }
        return max;

    }
}
