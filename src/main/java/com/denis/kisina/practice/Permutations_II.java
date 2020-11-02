package com.denis.kisina.practice;

import java.util.*;

public class Permutations_II {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2};
        System.out.println(permuteUnique(arr));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return results;
        }

        Arrays.sort(nums);

        List<Integer> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        allPermutations(nums, results, permutations, used);

        return results;
    }

    private static void allPermutations(int[] nums, List<List<Integer>> results, List<Integer> permutations, boolean[] used){

        if(permutations.size() == nums.length){
            results.add(new ArrayList<Integer>(permutations));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i])
                continue;
            used[i] = true;
            permutations.add(nums[i]);
            allPermutations(nums, results, permutations, used);
            permutations.remove(permutations.size()-1);
            used[i] = false;
            while(i+1 < nums.length && nums[i] == nums[i+1]){
                ++i;
            }
        }

    }
}
