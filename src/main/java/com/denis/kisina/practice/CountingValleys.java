package com.denis.kisina.practice;

public class CountingValleys {
    public int countingValleys(int n, String s) {
        int groundLevel = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                groundLevel--;
            }
            if (s.charAt(i) == 'U') {
                if(groundLevel == -1){
                    count++;
                }
                groundLevel++;
            }
        }
        return count;
    }
}
