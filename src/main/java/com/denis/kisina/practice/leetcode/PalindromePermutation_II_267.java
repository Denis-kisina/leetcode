package com.denis.kisina.practice.leetcode;

import java.util.*;

public class PalindromePermutation_II_267 {

    public static void main(String[] args) {
        System.out.println(generatePalindromes("aab"));
    }
    public static List<String> generatePalindromes(String s) {
        Set<String> result = new HashSet<>();
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];

        if (!isPalindromePermutation(s, map)) {
            return new ArrayList<>();
        }else{
            char ch = 0;
            int k = 0;
            for (int i = 0; i < 128; i++) {
                if (map[i] % 2 == 1) {
                    ch = (char) i;
                }
                for (int j = 0; j < map[i] / 2; j++) {
                    st[k++] = (char) i;
                }
            }
            permute(st, 0, ch, result);
        }


        return new ArrayList<String>(result);
    }

    private static void permute(char[] st, int l, char ch, Set<String> result) {
        if (l == st.length) {
            result.add(new String(st) + (ch == 0 ? "" : ch) + new StringBuffer(new String(st)).reverse());
        } else {
            for (int k = l; k < st.length; k++) {
                if (st[k] != st[l] || k == l) {
                    swap(st, l, k);
                    permute(st, l + 1, ch, result);
                    swap(st, l, k);
                }
            }
        }
    }

    private static void swap(char[] st, int l, int k) {
        char temp = st[l];
        st[l] = st[k];
        st[k] = temp;

    }

    private static boolean isPalindromePermutation(String s, int[] map) {

        int count = 0;
        for (char i = 0; i < 128 && count <=1; i++) {
            int ct = 0;
            for (int j = 0; j < s.length(); j++) {

                if (i == s.charAt(j)) {
                    map[s.charAt(j)]++;
                    ct++;
                }
            }
            count += ct % 2;
        }
        return count <= 1;
    }
}
/*
    Approach #2 Backtracking [Accepted]

    Algorithm

    It might be possible that no palindromic permutation could be possible for the given string s.
    Thus, it is useless to generate the permutations in such a case. Taking this idea, firstly we check if a palindromic permutation is possible for s.
    If yes, then only we proceed further with generating the permutations. To check this, we make use of a hashmap map
    map which stores the number of occurences of each character(out of 128 ASCII characters possible). If the number of characters with odd number of occurences exceeds 1, it indicates that no palindromic permutation is possible for s.
    To look at this checking process in detail, look at Approach 4 of the article for Palindrome Permutation.

    Once we are sure that a palindromic permutation is possible for s, we go for the generation of the required permutations.
    But, instead of wildly generating all the permutations, we can include some smartness in the generation of permutations i.e. we can generate only those permutations which are already palindromes.

    One idea to to do so is to generate only the first half of the palindromic string and to append its reverse string to itself to generate the full length palindromic string.

    Based on this idea, by making use of the number of occurences of the characters in
    s stored in map, we create a string st which contains all the characters of s but with the number of occurences of these characters in st reduced to half their original number of occurences in s.

    Thus, now we can generate all the permutations of this string st and append the reverse of this permuted string to itself to create the palindromic permutations of s.

    In case of a string s with odd length, whose palindromic permutations are possible, one of the characters in s must be occuring an odd number of times. We keep a track of this character,
    ch, and it is kept separte from the string st. We again generate the permutations for st similarly and append the reverse of the generated permutation to itself, but we also place the character ch at the middle of the generated string.

    In this way, only the required palindromic permutations will be generated. Even if we go with the above idea, a lot of duplicate strings will be generated.

    In order to avoid generating duplicate palindromic permutations in the first place itself, as much as possible, we can make use of this idea. As discussed in the last approach, we swap the current element with all the elements lying towards its right to generate the permutations. Before swapping, we can check if the elements being swapped are equal. If so, the permutations generated even after swapping the two will be duplicates(redundant). Thus, we need not proceed further in such a case.

 */
/*
    267. Palindrome Permutation II
    Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

    Example 1:

    Input: "aabb"
    Output: ["abba", "baab"]
    Example 2:

    Input: "abc"
    Output: []
 */