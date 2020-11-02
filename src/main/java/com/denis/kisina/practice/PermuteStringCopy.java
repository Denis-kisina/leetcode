package com.denis.kisina.practice;


import java.util.*;

public class PermuteStringCopy {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();


        if(nums == null || nums.length == 0){
            return results;
        }

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        for(Integer i: nums)
            subset.add(i);

        allPermutations( results, subset, 0);

        return results;
    }

    private static void allPermutations(List<List<Integer>> results, List<Integer> subset, int index){

        if(index == subset.size()){
            results.add(new ArrayList<Integer>(subset));
        }else{
            for(int i = index; i < subset.size(); i++){
                Collections.swap(subset, index, i);
                allPermutations(results, subset, index+1);
                Collections.swap(subset, index, i);
            }
        }
    }

    private void swap(int[] nums, int start, int last){
        int temp = nums[start];
        nums[start] = nums[last];
        nums[last] = temp;
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
        int[] input = {1,2,3};

        System.out.println(permuteUnique(input));
    }

}
