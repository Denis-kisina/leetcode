package com.denis.kisina.practice;

public class MergeStrings {
    StringBuilder sb = new StringBuilder();

    public String merge(String s, String t){

        if(s == null && t == null){ return null;}
        if(s == null || s.isEmpty()){return sb.append(t).toString();}
        if(t == null || t.isEmpty()){return sb.append(s).toString();}

        if(s.charAt(0) < t.charAt(0)){
            sb.append(s.charAt(0));
            merge(s.substring(1), t);
        }else{
            sb.append(t.charAt(0));
            merge(s, t.substring(1));
        }

        return sb.toString();
    }
}
