package com.denis.kisina.practice;

public class JumpingOnClouds {
    public int jumpingOnClouds(int[] c) {
        int numJumps = 0;
        int i = 0;

       while(i < c.length-1){
           if(i == c.length-2 || c[i + 2] == 1){
               i++;
           }else{
               i += 2;
           }
           numJumps++;

       }

        return numJumps;
    }

}
