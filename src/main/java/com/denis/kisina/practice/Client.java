package com.denis.kisina.practice;

import java.util.*;

public class Client {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] A = new int[]{20, 10, 8, 6, 4, 2};
        wave(arr);
        System.out.println();
        wave(A);
    }

    public static void wave(int[]  arr) {
        int n = arr.length;

        for(int i = 1; i < n-1; i++) {

            if(i%2==0 && arr[i] < arr[i-1])
                swap(arr, i, i-1);
            if(i%2 == 1 && arr[i] > arr[i-1])
                swap(arr, i, i-1);
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp =  arr[i];
        arr[i] =  arr[i1];
        arr[i1] = tmp;
    }
}
