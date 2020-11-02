package com.denis.kisina.practice;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {2,1,2,4,3};
        /*
        result [4,2,4,-1,-1]
         */
        System.out.println(Arrays.toString(nextGreaterElement(arr)));

        System.out.println("-----");



        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));

        System.out.println("-----");
        int[] t = {2,1,2,4,3};
         /*
        result [4,2,4,-1,4]
         */
        System.out.println(Arrays.toString(nextGreaterElements(t)));
    }

    public static int[] nextGreaterElement(int[] nums){
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.empty() && s.peek() <= nums[i]){
                s.pop();
            }
            ans[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return ans;

    }
    /*
    Give you T = [73, 74, 75, 71, 69, 72, 76, 73], and you return [1, 1, 4, 2, 1, 1, 0, 0]
     */
    public static int[] dailyTemperatures(int[] temps){
        int[] ans = new int[temps.length];
        Stack<Integer> s = new Stack<>();

        for(int i = temps.length -1; i >= 0; i--){
            while(!s.empty() && temps[s.peek()] <= temps[i]){
                s.pop();
            }
            ans[i] = s.empty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return ans;
    }
    /*
    Give you an array [2,1,2,4,3],and you return an array [4,2,4,-1,4]
     */
    public static int[]  nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 2*n- 1; i >= 0; i--){
            while(!s.empty() && s.peek() <= nums[i%n])
                s.pop();
            ans[i%n] = s.empty() ? -1 : s.peek();
            s.push(nums[i%n]);
        }
        return ans;
    }





























}
