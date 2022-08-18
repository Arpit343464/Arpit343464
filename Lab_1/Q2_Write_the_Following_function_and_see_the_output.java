package com.Lab.Lab_1;

public class Q2_Write_the_Following_function_and_see_the_output {
    public static void main(String[] args) {
        first();
    }
    static void first(){
        second();
        System.out.println("I am the first");
    }
    static void second(){
        third();
        System.out.println("I am the second");
    }static void third(){
        fourth();
        System.out.println("I am the third");
    }static void fourth(){
        System.out.println("I am the fourth");
    }


}
