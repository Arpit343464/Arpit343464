package com.Lab.Lab_1;

import java.lang.reflect.Array;

public class Q8_Write_the_reverse_string {
    static String reverseString(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(reverseString(str));
    }

}
