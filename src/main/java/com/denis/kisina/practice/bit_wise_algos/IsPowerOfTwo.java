package com.denis.kisina.practice.bit_wise_algos;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }

    /**
     *
     * @param x normal implemetation
     * @return
     */
//    public static boolean isPowerOfTwo(int x){
//        if(x == 0){
//            return false;
//        }else{
//            while(x%2 == 0)
//                x /=2;
//        }
//        return (x == 1);
//    }

    /**
     * @param x bit wise implementation
     * @return
     */
    public static boolean isPowerOfTwo(int x) {
        return (x != 0) && ((x & x - 1) == 0);
    }

}
