package com.Lab.Lab_1;

public class Q4_fibonacci {
    public static void main(String[] args) {
        double ans = fib(0);
        if(ans == -1){
            System.out.println("positive integer only, please");
        }
        else{
            System.out.println((int)ans);
        }
    }
    static double fib(double n){
        if(n <= 0 || n % 1 != 0){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else{
            return fib(n - 1)+fib(n - 2);
        }
    }
}
