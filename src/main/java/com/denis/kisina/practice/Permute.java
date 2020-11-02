package com.denis.kisina.practice;

import java.util.*;

public class Permute {

    private List<List<Integer>> permute(int[] nums) {

        if (nums == null)
            return null;

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> numbers_list = new ArrayList<>();

        for (int n : nums)
            numbers_list.add(n);

        int len = nums.length;

        permute(len, numbers_list, output, 0);

        return output;
    }

    private void permute(int len, List<Integer> subList, List<List<Integer>> output, int first) {

        if (first == len) {
            output.add(new ArrayList<Integer>(subList));
        } else {
            for (int i = first; i < len; i++) {
                Collections.swap(subList, first, i);
                permute(len, subList, output, first + 1);
                Collections.swap(subList, first, i);
            }
        }


    }

    public static void main(String[] args) {
        /*
        Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
         */
        int[] input = {1, 2, 3};

        System.out.println(new Permute().permute(input));
    }
}
