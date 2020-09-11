package com.denis.kisina.practice;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int singleValue = 0;

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])){
                map.put(nums[i], map.getOrDefault(nums[i], 1) +1 );
            }else{
                map.put( nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()
             ) {
            if(entry.getValue() == 1){
                singleValue = entry.getKey();
            }
        }

        return singleValue;


    }
}
