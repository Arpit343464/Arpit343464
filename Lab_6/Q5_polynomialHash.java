package com.Lab.Lab_6;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
class polynomialHash{
     int M;
     int a;
     int[] hashArray;
     String[] strKeys;
     int[] keys;
     Liner_Probing m;
     public polynomialHash(int M, int a, String[] strKeys){
         this.M = M;
         this.a = a;
         this.strKeys = strKeys;
         this.hashArray = new int[M];
         this.keys = new int[strKeys.length];
         for (int i = 0; i < strKeys.length; i++) {
             keys[i] = polynomial(strKeys[i], a);
         }
         this.m = new Liner_Probing(M, keys);
     }
     public void polynomialValue(){
         System.out.println(Arrays.toString(keys));
     }
     public void print(){
         m.print();
     }
     public int polynomial(String str, int a){
         return value(str.length(), a, str);
     }
     public int value(int n, int a, String str){
         int sum = 0;
         for (int i = 0; i < n; i++) {
             sum += str.charAt(i)*Math.pow(a, n - i);
         }
         return sum;
     }
}
public class Q5_polynomialHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] str = {"fist", "sift", "shift", "fast", "faster", "shaft"};
        polynomialHash M1 = new polynomialHash(17, a, str);
        polynomialHash M2 = new polynomialHash(37, a, str);
        M1.polynomialValue();
        M1.print();
        M2.polynomialValue();
        M2.print();
    }
}
