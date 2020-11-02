package com.denis.kisina.practice.leetcode;

import java.util.*;

public class PermutationInString567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        int len = s2.length();
        int len1 = s1.length();

        s1 = sort(s1);

        for (int i = 0; i <= len - len1; i++) {
            if (checkPermutation(s1, s2, i)) {
                return true;
            }
        }

        return false;
    }

    private String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

    private boolean checkPermutation(String s1, String s2, int i) {

        String sub = sort(s2.substring(i, i + s1.length()));

        if (s1.equals(sub))
            return true;

        return false;
    }
}
