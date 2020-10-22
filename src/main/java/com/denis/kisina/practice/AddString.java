package com.denis.kisina.practice;

public class AddString {
    public String addString(String num1, String num2){
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while(i > -1 || j > -1){
            int d1 = i > -1 ? num1.charAt(i) - '0' : 0;
            int d2 = j > -1 ? num2.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;
;
            sb.append(sum%10);
            carry = sum/10;
            i--; j--;

        }
        if(carry == 1)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
