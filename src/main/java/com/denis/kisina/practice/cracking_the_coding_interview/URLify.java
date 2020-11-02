package com.denis.kisina.practice.cracking_the_coding_interview;

public class URLify {
    /*
    URLify (Write a method to replace all spaces in a string with '%20').
    You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
    (Note: if implementing in java, please use a character array so that you can perform this operation in place.)

    Input: "Mr John Smith   ", 13
    Output: "Mr%20John%20Smith"
     */

    public static String URLify(String s, int len){
        char[] c = s.toCharArray();
        int spaceCount = 0;
        int newLen = 0;

        for(int i = 0; i < c.length; i++){
            if(c[i] == ' '){
                spaceCount++;
            }
        }
        newLen = len + (spaceCount*2);

        char[] c1 = new char[newLen];

        for(int i = len - 1; i > -1; i--){
            if(c[i] == ' '){
                c1[newLen -1] = '0';
                c1[newLen -2] = '2';
                c1[newLen -3] = '%';
                newLen = newLen - 3;
            }else{
                c1[newLen-1] = c[i];
                newLen = newLen - 1;
            }
        }
        return String.valueOf(c1);
    }
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith    ",13 ));
    }
}
