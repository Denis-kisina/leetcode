package com.denis.kisina.practice;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // create data structure HashMap
        // interate through the string as you check if it contains say the i
        //

        if (s == "" || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0, max = 0, j = 0, i = 0;


        while (j < s.length()) {

            map.put(s.charAt(j), j);
            count++;
            i = j + 1;
            while (i < s.length()) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), i);
                    count++;
                    i++;
                    max = count > max ? count : max;
                } else {
//                    j = i;
                    max = count > max ? count : max;
//                    count = 0;
                    map = new HashMap<>();
                    break;
                }


            }
            count = 0;
            j++;
        }


        return max;
    }
}
