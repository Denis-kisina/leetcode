package com.denis.kisina.practice;

import java.util.*;

public class SubArrayMinimums {

    public static void main(String[] args) {
        /*
        Input: [3,1,2,4]
    Output: 17
    Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
         */
        System.out.println(new SubArrayMinimums().sumSubArrayMins(new int[]{3,1,2,4}));
    }
    public int sumSubArrayMins(int[] A) {
        int result = 0;
        int N = A.length;
        int MOD = (int)10e9*7;
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[N];
        for (int i = 0; i < A.length; i++) {
            while(!stack.isEmpty() && A[i] <= A[stack.peek()]){
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? - 1 : stack.peek();
            stack.push(i);
        }

        int[] next = new int[N];
        stack = new Stack<>();

        for(int k = N-1; k > - 1;  k--){
            while(!stack.isEmpty() && A[k] < A[stack.peek()]){
                stack.pop();
            }
            next[k] = stack.isEmpty() ? N : stack.peek();
            stack.push(k);
        }

        for(int i = 0; i < N; i++){
            result = (result+ A[i]*(i-prev[i]) * (next[i] - i)%MOD)%MOD;
        }

        return result;


    }

//    private int sumSubArrayMins(int[] A, int start, int end){
//        if(start == A.length && end == A.length){
//            return A[start];
//        }else{
//            if(end == A.length + 1){
//                sumSubArrayMins(A, start+1, start+1);
//            }else{
//                sumSubArrayMins(A, start, end+1);
//            }
//        }
//        return 0;
//    }
}
