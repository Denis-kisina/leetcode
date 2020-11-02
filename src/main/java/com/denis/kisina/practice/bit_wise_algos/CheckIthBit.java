package com.denis.kisina.practice.bit_wise_algos;

public class CheckIthBit {

    public static void main(String[] args) {
        System.out.println(check(20, 2));
    }

    public static boolean check(int n, int i){

        if((n & (1 << i)) > 0){
            return true;
        }else{
            return false;
        }
    }
}
