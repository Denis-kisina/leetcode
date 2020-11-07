package com.denis.kisina.practice;

import java.util.*;

public class TestStringForWellFormed {
    public static void main(String[] args) {
        System.out.println(isWellFormed("([]){()}"));
    }

    public static boolean isWellFormed(String str) {

        Deque<Character> leftChars = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                leftChars.addFirst(str.charAt(i));
            } else {
                if(leftChars.isEmpty()) // unmatched right char
                    return false;

                if((str.charAt(i) == ')' && leftChars.peekFirst() != '(')
                        || (str.charAt(i) == '}' && leftChars.peekFirst() != '{')
                        || (str.charAt(i) == ']' && leftChars.peekFirst() != '[') ){
                    return false; // mismatched chars
                }else {
                    leftChars.removeFirst();
                }
            }
        }
        return leftChars.isEmpty();
    }
}
