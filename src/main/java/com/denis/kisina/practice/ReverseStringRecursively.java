package com.denis.kisina.practice;

class ReverseStringRecursive {

    public String reverse(String s){
        if(s == null || s.length() == 0){return s;}

        String first = "" + s.charAt(0);

        return reverse(s.substring(1)) + first;
     }
}
