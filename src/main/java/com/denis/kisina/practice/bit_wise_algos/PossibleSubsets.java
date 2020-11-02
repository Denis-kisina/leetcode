package com.denis.kisina.practice.bit_wise_algos;

import java.util.*;

public class PossibleSubsets {
    public static void main(String[] args) {
        char [] arr = new char[] {'a','b','c'};
//        possibleSubsets(arr, 2);
        int[] arr1 = new int[] {1,2,3};
        System.out.println(subset(arr1));
    }
    public static void possibleSubsets(char [] arr, int n){

        char[] subset = new char[arr.length];
        helper(arr, subset, 0);
    }

    private static void helper(char[] arr, char[] subset, int i) {

        if(i == arr.length){
            System.out.println(Arrays.toString(subset));
        }else{
            subset[i] = '.';
            helper(arr, subset, i+1);
            subset[i] = arr[i];
            helper(arr, subset, i+1);
        }

    }

    public static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> results = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return results;

        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();

        toFindAllSubsets(results, subset, nums, 0);

        return results;

    }

    private static void toFindAllSubsets(List<List<Integer>> results, List<Integer> subset, int[] nums, int indexStart) {
        results.add(new ArrayList<>(subset));

        for(int i = indexStart; i < nums.length; i++){
            subset.add(nums[i]);
            toFindAllSubsets(results, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
}
