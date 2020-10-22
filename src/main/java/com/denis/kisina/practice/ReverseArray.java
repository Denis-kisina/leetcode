package com.denis.kisina.practice;

import java.util.Arrays;

public class ReverseArray {
    public void reverse(int[] array){
        for(int i = 0; i < array.length/2; i++){
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,3,2,1};
        System.out.println(Arrays.toString(array));
        System.out.println("reversed -----");
        new ReverseArray().reverse(array);
        System.out.println(Arrays.toString(array));
    }
}
