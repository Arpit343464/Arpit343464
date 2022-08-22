package com.Lab.Lab_2;

public class Q1_Search_the_target_element {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        System.out.println(srch(arr, 4));
    }
    static int srch(int[] arr, int element){
        int count = 1;
        for (int i: arr) {
            if(i == element){
                return count;
            }
            count ++;
        }
        return  -1;
    }

}
