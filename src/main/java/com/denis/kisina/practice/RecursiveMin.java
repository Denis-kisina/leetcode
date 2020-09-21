package com.denis.kisina.practice;

public class RecursiveMin {

    public Character rmin(String str){

        if(str == null || str.length() == 0){return null;}

        char ch = str.charAt(0);
        if(str.length() == 1){ return ch;}

        char c = rmin(str.substring(1));
        return ch < c ? ch : c;
    }
}
