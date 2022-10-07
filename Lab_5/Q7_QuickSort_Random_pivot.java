package com.Lab.Lab_5;
import java.lang.Math;
import java.util.Arrays;

public class Q7_QuickSort_Random_pivot {
    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 2, 9, 6, 1, 2, 3};
        QuickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }
    static void QuickSort(int s, int e, int[] arr){
        if(s < e){
            int pi = partition(s, e, arr);

            QuickSort(s, pi, arr);
            QuickSort(pi + 1, e, arr);
        }
    }
    static int partition(int s, int e, int[] arr){
        double r = Math.random();
        int pivotInx = (int)(r * (e - s)) + s;
        int pivot = arr[pivotInx];
        int j = e;
        for(int i = 0; i < pivotInx; i ++){
            if(arr[i] > pivot){
                while(arr[j] > arr[i]){
                    j--;
                }
                swap(j, i, arr);
            }
        }
        if(arr[pivotInx] > arr[j]){
            swap(pivotInx, j, arr);
        }
        return pivotInx;
    }
    static void swap(int j, int i, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
