package com.denis.kisina.practice;

public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if(word.length() < 1)
            return true;

        int countCapital = 0;
        int countSmall = 0;

        for (int i = 1; i < word.length(); i++) {
            int len = word.length();
            if('A' >= word.charAt(0) || word.charAt(0) <= 'Z'){
                if('A' >= word.charAt(i) || word.charAt(i) <= 'Z' ){
                    countCapital++;
                }else{
                    countSmall++;
                }

            }else {
                if(word.charAt(i) > 'Z')
                    countSmall++;
            }
        }
        if(countCapital == word.length()-1){
            return true;
        }else if (countSmall == word.length()-1){
            return true;
        }else
        return false;

    }
}
