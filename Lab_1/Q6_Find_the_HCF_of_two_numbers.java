package com.Lab.Lab_1;

public class Q6_Find_the_HCF_of_two_numbers {
    public static void main(String[] args) {
        int ans = HCF(6, 9);
        System.out.println(ans);
    }

    static int HCF(int n1, int n2) {
        if(n1 == 0){
            return n2;
        }
        return HCF(n2 % n1, n1);
    }
}
