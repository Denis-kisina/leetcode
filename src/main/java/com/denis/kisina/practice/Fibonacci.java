package com.denis.kisina.practice;

import com.sun.source.tree.ReturnTree;

public class Fibonacci {
    /*
    Using Recursion

     */

    public int fib(int i){
        if(i == 0 || i == 1) return i;

        return fib(i - 1) +  fib(i - 2);
    }

    /*
    Fib using memoization
     */

    public int fibonacci(int n){
        return fibonacci(n, new int[n + 1]);
    }

    private int fibonacci(int n, int[] memo) {
        if(n == 0 || n == 1) return n;

        if(memo[n] == 0){
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        }
        return memo[n];
    }

    /*
    Fibonacci storing and using the previous values
     */

    public int fibonacci3(int n){
        if(n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;

        for(int i = 2; i < n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }


}
