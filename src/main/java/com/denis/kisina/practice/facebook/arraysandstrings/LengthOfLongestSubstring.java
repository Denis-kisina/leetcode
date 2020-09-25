package com.denis.kisina.practice.facebook.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    /*
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    Example 4:

    Input: s = ""
    Output: 0
     */


    /*

    Brute force approach
    O(n^3)
     */
    /*
    public int LengthOfLongestSubstring(String s) {

        int lengthSubstring = 0, start = 0, move = 0;

        while (start < s.length()){
            move = start + 1;
            while(move <= s.length()){
                if(allUnique(s, start, move)){
                    int dif = move-start;
                    lengthSubstring = dif > lengthSubstring?dif:lengthSubstring;
                }
                move++;
            }
            start++;
        }
        return lengthSubstring;
    }

    private boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();

        for(int i = start; i < end; i++){
          if(set.contains(s.charAt(i))){
              return false;
          }
          set.add(s.charAt(i));
        }
        return true;
    }

    */

    /*

    Sliding windows solution

     */

    public int LengthOfLongestSubstring(String s){
        int len = s.length(), i = 0, j = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();

        while(i < len && j < len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
















