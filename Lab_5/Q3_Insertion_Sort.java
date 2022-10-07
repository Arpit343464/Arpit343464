package com.Lab.Lab_5;

import java.util.Arrays;

public class Q3_Insertion_Sort{
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1, 7, 6, 8, 1};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void InsertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]){
                continue;
            }
            int index = binarySearch(arr[i], 0, i, arr);
            for (int j = i; j > index; j--) {
                swap(j, j - 1, arr);
            }
        }
    }
    static int binarySearch(int target, int s, int e,int[] arr){
        while(s < e){
            int mid = s + (e - s)/2;
            if(target < arr[mid]){
                e = mid - 1;
            }
            else if(target > arr[mid]){
                s = mid + 1;
            }
            else{
                return mid;
            }
        }
        if(arr[s] < target){
            return e+1;
        }
        if(e < 0){
            return s;
        }
        return e;
    }
    static void swap(int j, int i, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
