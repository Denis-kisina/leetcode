package com.denis.kisina.practice;

public class LastStudentStanding {

    public static void main(String[] args) {
       int result =  lastStudentStanding(6,2);
        System.out.println(result);
    }

    public static int lastStudentStanding(int n, int k){
       boolean left = true;
       int head = 1;
       int remaining = n;

       while(remaining > 1){
           if(left || remaining%2 == 1){
               head = head + k;
           }
           remaining = remaining/2;
//           k = k*2;
           left = !left;
       }
       return head;
    }

    public static int lastStudentStanding1(int n, int k){
        int lastStudent = 0;
        int[] circle = new int[n];
        int j = 1, b = 0, i =0;

        while(j <= n){
            circle[b++] = j++;
        }
        int arraySize = n -1;
        int count = 1;
        while(true){
            if(circle[i%n] != 0 && count != k){
                circle[i%n] = 0;
                count = 0;
                arraySize--;
            }else{
                count++;
                i++;
            }
            if(arraySize == 1){for (int numS: circle ){if(numS!=0){lastStudent=numS;}}return lastStudent;}
        }
    }
}
