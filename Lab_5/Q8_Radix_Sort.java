package com.Lab.Lab_5;

import java.util.Arrays;
public class Q8_Radix_Sort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 52, 18, 22, 67, 123, 76, 20, 41, 235};
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void radixSort(int[] arr, int n){
        int max = max(arr);
        for(int place = 1; max / place > 0; place *= 10){
            count(arr, arr.length, place);
        }
    }
    static int max(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    static void count(int[] arr, int n, int place){
        int output[] = new int[n];
        int count[] = new int [10];
        Arrays.fill(count, 0);
        for(int i = 0; i < n; i++){
            count[(arr[i]/place) % 10] ++;
        }
        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        for(int i = n-1; i >= 0; i--){
            output[count[(arr[i]/place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        for(int i = 0; i < n; i ++){
            arr[i] = output[i];
        }
    }
}
