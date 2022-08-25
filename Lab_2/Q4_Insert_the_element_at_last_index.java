package com.Lab.Lab_2;

import java.util.Arrays;
class myFunctions{
    public void copy(int[] arr1, int[] arr2, int index1, int index2){
        if(index1 >= arr1.length){
            return;
        }
        arr2[index2] = arr1[index1];
        index1++;
        index2++;
        copy(arr1, arr2, index1, index2);
    }
}
public class Q4_Insert_the_element_at_last_index {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9};
        System.out.println(Arrays.toString(insatend(arr, 55)));
    }
    static int[]  insatend(int[] array, int element){
        int[] newArr = new int[array.length + 1];
        myFunctions cp = new myFunctions();
        cp.copy(array, newArr, 0, 0);
        newArr[array.length] = element;
        return newArr;
    }
}
