package com.denis.kisina.practice;

import java.util.*;
import java.util.Arrays;
import java.util.StringJoiner;

public class SpinWords {
    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] stringArray = sentence.split(" ");

        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i].length() >= 5){
                stringArray[i] = reversed(stringArray[i]);
                System.out.println(stringArray[i]);
            }
        }

     StringJoiner joiner = new StringJoiner(" ");

        List<String> listString = Arrays.asList(stringArray);
        return  String.join(" ", listString);

    }
    private String reversed(String str){
        if(str.isEmpty()){return str;}
        return str.charAt(str.length()-1) + reversed(str.substring(0, str.length()-1));
    }
}
