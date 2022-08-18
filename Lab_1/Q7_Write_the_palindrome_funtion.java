package com.Lab.Lab_1;

public class Q7_Write_the_palindrome_funtion {
    public static void main(String[] args) {
        String str = "ABCDCBA";
        boolean ans = IsPali(str, 0, str.length()-1);
        System.out.println(ans);
    }
    static boolean IsPali(String str, int n1, int n2){
        while(n1 != (str.length()-1)  / 2){
            if(str.charAt(n1) == str.charAt(n2)){
                return IsPali(str,  n1+1, n2-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
