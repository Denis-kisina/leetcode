package com.denis.kisina.practice;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here
    private boolean stringContainsAllCharacters(String window_snippet, String t) {
        Map<Character, Integer> required_characters = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int occurrence_of_character = required_characters.getOrDefault(t.charAt(i), 0);
            required_characters.put(t.charAt(i), occurrence_of_character + 1);
        }

        for (int i = 0; i < window_snippet.length(); i++) {
            char cur_char = window_snippet.charAt(i);
            if (required_characters.containsKey(cur_char)) {
                int new_occurrence_count = required_characters.get(cur_char) - 1;

                if (new_occurrence_count == 0) {
                    required_characters.remove(cur_char);
                } else {
                    required_characters.put(cur_char, new_occurrence_count);
                }

            }
        }
        return required_characters.isEmpty();
    }

    int minLengthSubstring(String s, String t) {
        // Write your code here

        int n = s.length();
        int min_window_length_seen_so_far = Integer.MAX_VALUE;
        String min_window = "";

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                String window_snippet = s.substring(left, right + 1);
                boolean window_contains_all_chars = stringContainsAllCharacters(window_snippet, t);

                if (window_contains_all_chars && window_snippet.length() < min_window_length_seen_so_far) {
                    min_window = window_snippet;
                    min_window_length_seen_so_far = window_snippet.length();
                }
            }
        }

        return min_window_length_seen_so_far;
    }



        // These are the tests we use to determine if the solution is correct.
        // You can add your own at the bottom, but they are otherwise not editable!
        int test_case_number=1;
        void check(int expected,int output){
        boolean result=(expected==output);
        char rightTick='\u2713';
        char wrongTick='\u2717';
        if(result){
        System.out.println(rightTick+" Test #"+test_case_number);
        }
        else{
        System.out.print(wrongTick+" Test #"+test_case_number+": Expected ");
        printInteger(expected);
        System.out.print(" Your output: ");
        printInteger(output);
        System.out.println();
        }
        test_case_number++;
        }
        void printInteger(int n){
        System.out.print("["+n+"]");
        }
public void run()throws IOException{
        String s_1="dcbefebce";
        String t_1="fd";
        int expected_1=5;
        int output_1=minLengthSubstring(s_1,t_1);
        check(expected_1,output_1);

        String s_2="bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2="cbccfafebccdccebdd";
        int expected_2=-1;
        int output_2=minLengthSubstring(s_2,t_2);
        check(expected_2,output_2);

        // Add your own test cases here

        }
public static void main(String[]args)throws IOException{
        new Main().run();
        }
        }
