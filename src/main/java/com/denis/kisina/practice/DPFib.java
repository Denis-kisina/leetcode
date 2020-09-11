package com.denis.kisina.practice;

public class DPFib {

//    using pure recursion

    public int fib(int n){
        if(n < 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public void fib(){
        //fibresult[0] = 1;

    }

}
