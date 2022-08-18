package com.Lab.Lab_1;

public class Q3_addUp_the_number_from_0_to_n {
    public static void main(String[] args) {
        double ans = (int)addUp(10);
        if(ans == -1){
            System.out.println("Positive integer only, please");
        }
        else{
            System.out.println((int)ans);
        }
    }
    static double addUp(double n){
        if(n < 0 || n%1 != 0){
            return -1;
        }
        while(n > 0){
            return addUp(n-1)+n;
        }
        return 0;
    }
}
