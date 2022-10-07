package com.Lab.Lab_5;

import java.util.Arrays;

public class Q2_Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 3, 2, 9, 8, 1, 4};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = min(i, arr);
            swap(min, i, arr);
        }
    }
    static int min(int i, int[] arr){
        for (int j = i; j < arr.length; j++) {
            if(arr[i] > arr[j]){
                i = j;
            }
        }
        return i;
    }
    static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
