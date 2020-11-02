package com.denis.kisina.practice.bit_wise_algos;

public class CountOnes {

    public static void main(String[] args) {
        System.out.println(countOnes(23));
    }

    public static int countOnes(int n){

        int count = 0;

        while(n != 0){
            n = n&n-1;
            count++;
        }
        return count;
    }
}
