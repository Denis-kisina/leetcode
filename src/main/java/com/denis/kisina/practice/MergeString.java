package com.denis.kisina.practice;

public class MergeString {

    public static void main(String[] args) {
        System.out.println(new MergeString().merge("ace", "bd"));
    }



    StringBuilder result = new StringBuilder();

    public String merge(String s, String t){
        if(s == null && t == null){return null;}
        if(s == null || s.isEmpty()){
            result.append(t);
            return result.toString();
        }
        if(t == null || t.isEmpty()){
            result.append(s);
            return result.toString();
        }

        if(s.charAt(0) < t.charAt(0)){
            result.append(s.charAt(0));
            return merge(s.substring(1), t);
        }else{
            result.append(t.charAt(0));
            return merge(s, t.substring(1));
        }
    }
}
