package com.denis.kisina.practice;

class ReverseStringRecursive {

    public String reverse(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        String first = "" + s.charAt(0);

        return reverse(s.substring(1)) + first;
    }


    // function to segregate 0s and 1s
    static void segregate0and1(int arr[], int n) {
        int count = 0; // counts the no of zeros in arr

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
        }

        // loop fills the arr with 0 until count
        for (int i = 0; i < count; i++)
            arr[i] = 0;

        // loop fills remaining arr space with 1
        for (int i = count; i < n; i++)
            arr[i] = 1;
    }
}
