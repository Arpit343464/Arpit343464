package com.Lab.Lab_5;

import java.util.Arrays;

public class Q6_QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 9, 10, 2, 4, 1};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static int partition(int[] arr, int l, int h){  
        int m = l + (h - l)/2;
        int pivot = arr[m];
        int j = h;
        for(int i = 0; i < m; i ++){
            if(arr[i] > pivot){
                while(arr[j] > arr[i]){
                    j--;
                }
                swap(j, i, arr);
            }
        }
        if(arr[m] > arr[j]){
            swap(m, j, arr);
        }
        return m;
    }
    static void QuickSort(int[] arr, int l, int h){
        if(l < h){
            int pi = partition(arr, l, h);

            QuickSort(arr, l, pi);
            QuickSort(arr, pi + 1, h);
        }
    }
    static void swap(int j, int i, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
