package com.denis.kisina.practice.cracking_the_coding_interview;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    /*

    Given a string, determine if a permutation of the string could form a palindrome.

    Example 1:

    Input: "code"
    Output: false
    Example 2:

    Input: "aab"
    Output: true
    Example 3:

    Input: "carerac"
    Output: true
     */
    /*
    If a string with an even length is a palindrome, every character in the string must always occur an even number of times.
    If the string with an odd length is a palindrome, every character except one of the characters must always occur an even number of times.
    Thus, in case of a palindrome, the number of characters with odd number of occurrences can't exceed 1(1 in case of odd length and 0 in case of even length).

    Based on the above observation, we can find the solution for the given problem. The given string could contain almost all the ASCII characters from 0 to 127.
    Thus, we iterate over all the characters from 0 to 127. For every character chosen, we again iterate over the given string s and find the number of occurrences, ch, of the current character in s.
    We also keep a track of the number of characters in the given string s with odd number of occurrences in a variable count.

    If, for any character currently considered, its corresponding count, ch, happens to be odd, we increment the value of count, to reflect the same. In case of even value of ch for any character, the count remains unchanged.

    If, for any character, the count becomes greater than 1, it indicates that the given string s can't lead to the formation of a palindromic permutation based on the reasoning discussed above. But, if the value of

    count remains lesser than 2 even when all the possible characters have been considered, it indicates that a palindromic permutation can be formed from the given string s.
     */
    public static boolean canPermutePalindrome(String s) {
        int count = 0;
        for(char i = 0; i < 128 && count <= 1; i++){
            int ct = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == i){
                    ct++;
                }
                count += ct%2;
            }
        }
        return count <= 1;
    }
//    using hashmap
    public static boolean canPermutePalindrome2(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for(char key: map.keySet()){
            count += map.get(key)%2;
        }
        return count <= 1;
    }
//    using array
    public static boolean canPermutePalindrome3(String s){
        int[] map = new int[128];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)]++;
        }
        int count = 0;
        for(int key = 0; key < map.length && count <= 1; key++){
            count += map[key]%2;
        }
        return count <= 1;
    }

}
