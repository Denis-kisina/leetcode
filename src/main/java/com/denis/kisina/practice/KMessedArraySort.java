package com.denis.kisina.practice;

import java.util.*;

public class KMessedArraySort {
    public static void sortHeap(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i = 0; i <= k; i++){
            pq.add(arr[i]);
        }

        int index = 0;

        while(index < arr.length){
            arr[index++] = pq.poll();
            pq.add(arr[i++]);
        }

        while(index < arr.length){
            arr[index++] = pq.poll();
        }
    }
}
