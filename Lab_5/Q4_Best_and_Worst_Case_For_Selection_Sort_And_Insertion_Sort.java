package com.Lab.Lab_5;

import java.util.Arrays;

public class Q4_Best_and_Worst_Case_For_Selection_Sort_And_Insertion_Sort {
    public static void main(String[] args) {
        //Selection Sort Best case
        System.out.println("Selection Sort Best case");
        long start = System.nanoTime();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SelectionSort a1 = new SelectionSort(arr1);
        System.out.println(Arrays.toString(a1.returnArr(arr1)));
        long end = System.nanoTime();
        System.out.println("Elapsed Time in neno seconds: "+ (end-start));


        //Selection Sort Worst case
        System.out.println("Selection Sort Worst case");
        long start1 = System.nanoTime();
        int [] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort a2 = new SelectionSort(arr2);
        System.out.println(Arrays.toString(a2.returnArr(arr2)));
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in neno seconds: "+ (end1-start1));


        //InsertionSort Best Case
        System.out.println("InsertionSort Best Case");
        long start2 = System.nanoTime();
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        InsertionSort a3 = new InsertionSort(arr3);
        System.out.println(Arrays.toString(a3.returnArr(arr1)));
        long end2 = System.nanoTime();
        System.out.println("Elapsed Time in neno seconds: "+ (end2-start2));

        //InsertionSort Sort Worst case
        System.out.println("InsertionSort Sort Worst case");
        long start3 = System.nanoTime();
        int [] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort a4 = new InsertionSort(arr4);
        System.out.println(Arrays.toString(a4.returnArr(arr2)));
        long end3 = System.nanoTime();
        System.out.println("Elapsed Time in neno seconds: "+ (end3-start3));
    }
}
class SelectionSort{
    public SelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = min(i, arr);
            swap(min, i, arr);
        }
    }
    int min(int i, int[] arr){
        for (int j = i; j < arr.length; j++) {
            if(arr[i] > arr[j]){
                i = j;
            }
        }
        return i;
    }
    void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int[] returnArr(int[] arr){
        return arr;
    }
}

class InsertionSort{

    public InsertionSort(int[] arr){

    }
    int binarySearch(int target, int s, int e,int[] arr){
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
    void swap(int j, int i, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    int[] returnArr(int[] arr){
        return arr;
    }
}
