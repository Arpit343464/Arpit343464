package com.Lab.Lab_5;

import java.util.Arrays;

public class Q5_MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 5, 3, 2, 1, 9, 8};
        mergeSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int s, int e, int[] arr){
        if(s < e){
            int m = s + (e - s)/2;

            mergeSort(0, m, arr);
            mergeSort(m + 1, e, arr);

            merge(s, m, e, arr);
        }
    }
    static void merge(int s, int m, int e, int[] arr){
        int n1 = m - s + 1;
        int n2 = e - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i ++){
            left[i] = arr[s + i];
        }
        for(int j = 0; j < n2; j ++){
            right[j] = arr[m + 1 + j];
        }
        int k = s;
        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }


        while(j < n2){
            arr[k] = right[j];
            k++;
            j++;
        }

        while(i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
    }
}
