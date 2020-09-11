package com.denis.kisina.practice;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);


        int result = 0;

        for (int i = citations.length - 1; i >= 0; i--) {
            int count = citations.length - i;
            if (citations[i] >= count) {
                result = count;
            } else
                break;
        }
        return result;

    }
}
