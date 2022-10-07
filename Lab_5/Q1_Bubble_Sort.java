package com.Lab.Lab_5;

import java.util.Arrays;

public class Q1_Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 8, 6, 4, 8, 8, 3, 1};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    swap(j, j + 1, arr);
                    flag = 1;
                }
                count ++;
            }
            if(flag == 0){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Total Number of steps: " + count);
    }
    static void swap(int j, int i, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
