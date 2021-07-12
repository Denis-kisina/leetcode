package com.denis.kisina.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsecutivelyRepeated {

    public static Map<Character, Integer> getMapping(String str) {

        Map<Character, Integer> resultMap = new HashMap<>();

        helper(str, resultMap);


        return resultMap;
    }

    private static void helper(String str, Map<Character, Integer> resultMap) {

        Map<Character, Integer> result = new HashMap<>();

        char[] tempArray = str.toCharArray();
        StringBuilder unique = new StringBuilder();
        unique.append(tempArray[0]);
        for (int i = 1; i < tempArray.length - 1; i++) {
            if (tempArray[i] != unique.charAt(unique.length() - 1))
                unique.append(tempArray[i]);
        }
        System.out.println(unique.toString());
        for (int j = 0; j < unique.length(); j++) {

            result.put(unique.charAt(j), result.getOrDefault(unique.charAt(j), 0) + 1);

        }

        for(Map.Entry<Character, Integer> e: result.entrySet()){
            if(e.getValue() > 1)
                resultMap.put(e.getKey(), e.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println(getMapping("abbbcddddeffabbbbbbfffbbb"));
    }
}
