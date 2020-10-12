package com.denis.kisina.practice;

import java.util.*;

public class MinOperations {

    // Add any helper functions you may need here
    private boolean isAscending(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] >  arr[i]){
                return false;
            }
        }
        return true;
    }




    int minOperations(int[] arr) {
        // Write your code here

        int len = arr.length;

        String starting = "", destination = "", original = "", modified = "";
        Node temp = null;


        for(int i = 0; i <  len; i++)
            starting += arr[i];

        Arrays.sort(arr);
        for(int i = 0; i <  len; i++)
            destination += arr[i];

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(starting, 0));

        if(starting == destination) return 0;

        while(q.size() != 0){

            temp = q.poll();
            original = temp.start;
            for (int i = 2; i <= len; i++) {
                modified = original;

                modified = reverse(modified, i);
                if (modified.equals(destination) ) {
                    return temp.steps +1;
                }
                q.add(new Node(modified, temp.steps +1));
            }

        }

        return Integer.MIN_VALUE;
    }

    private String reverse(String modified, int index) {
        char temp[] = modified.toCharArray();
        int i =0;
        while(i < index){
            char c = temp[i];
            temp[i] = temp[index-1];
            temp[index-1] = c;
            i++; index--;
        }
        return String.valueOf(temp);
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

        int n_3 = 4;
//        int[] arr_3 = {1, 2, 4, 3};
        int[] arr_3 = {3, 4, 2, 1};
        int expected_3 = 3;
        int output_3 = minOperations(arr_3);
        check(expected_3, output_3);

    }

    public static void main(String[] args) {
        new MinOperations().run();
    }

    static class Node {
        public String start;
        public int steps;

        public Node(String start, int steps) {
            this.start = start;
            this.steps = steps;
        }
    }
}
