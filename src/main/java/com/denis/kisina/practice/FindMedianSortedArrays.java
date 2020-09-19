package com.denis.kisina.practice;

public class FindMedianSortedArrays {

    double median;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;


        int[] merged = new int[lengthNums1 + lengthNums2];

        int i = 0, j = 0, k = 0;

        while (i < lengthNums1 && j < lengthNums2) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < lengthNums1) {
            merged[k++] = nums1[i++];
        }

        while (j < lengthNums2) {
            merged[k++] = nums2[j++];
        }

        if (merged.length % 2 != 0) {
            int middle = merged.length / 2;

            median = merged[middle];
        } else {
            int middle = merged.length / 2;
            double n1 = merged[merged.length / 2];
            double n2 = merged[(merged.length / 2) - 1];
            median = (n1 + n2) / 2.0;
        }

        return median;
    }
}
