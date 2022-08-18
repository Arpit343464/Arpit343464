package com.Lab.Lab_1;

public class Q1_Factorial {
    public static void main(String[] args) {
        double fact = (int)fact(4);
        if(fact == -1){
            System.out.println("Positive Integer Only, please");
        }
        else{
            System.out.println((int)fact);
        }
    }
    static double fact(double n){
        if(n < 0 || n%1 != 0){
            return -1;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        double temp = fact(n-1)*n;
        return temp;
    }
}
