package com.denis.kisina.practice;

import java.util.*;

public class FindPairs {
    public int findPairs(int[] nums, int k) {

//        Arrays.sort(nums);
//
//        Set<Integer> set = new TreeSet<>();
//
//
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
        int count = 0;
//
//        int len = set.size();
//
//        List<Integer> list = new ArrayList<>();
//
//        list.addAll(set);
//
//
//        for (int i = len-1; i > 0; i--) {
//            for (int j = i-1; j >= 0; j--) {
//                if(list.get(i) - list.get(j) == k){
//                    count++;
//                }
//            }
//        }
//
//        for (int i = nums.length-1; i > 0; i--) {
//            for (int j = i-1; j >= 0; j--) {
//                if(nums[i] - nums[j] == k){
//                    count++;
//                }
//            }
//        }

        if(k < 0 || nums.length == 0 || nums == null ){return 0;}

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(k == 0){
                if(entry.getValue() >= 2){

                    count++;

                }
            }else{
                if(map.containsKey(entry.getKey() + k)){
                    count++;
                }
            }
        }


        return count;
    }
}










