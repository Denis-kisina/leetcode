package com.denis.kisina.practice;

public class PermuteString {

    public static void main(String[] args) {
        System.out.println(new PermuteString().checkInclusion("adc", "dcda"));
        System.out.println(new PermuteString().checkInclusion("ab", "eidbaccd"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1_len = s1.length();
        int s2_len = s2.length();

        if(s2 == null || s2.length() == 0 || s1_len > s2_len)
            return false;

        int[] s1_arr = new int[26];
        int[] s2_arr = new int[26];

        for(int i = 0; i < s1_len; i++){
            s1_arr[s1.charAt(i) - 'a']++;
            s2_arr[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2_len - s1_len; i++){
            if(isPermutation(s1_arr, s2_arr))
                return true;
            s2_arr[s2.charAt(i) - 'a']--;
            s2_arr[s2.charAt(i + s1_len) - 'a']++;
        }

        if(isPermutation(s1_arr, s2_arr))
            return true;
        return false;
    }

    private boolean isPermutation(int[] s1_arr, int[] s2_arr) {
        for(int i = 0; i < s1_arr.length; i++){
            if(s1_arr[i] != s2_arr[i])
                return false;
        }
        return true;
    }
}
