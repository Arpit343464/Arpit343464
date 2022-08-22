package com.Lab.Lab_2;

import java.util.Arrays;

public class Q2_Insert_the_element_in_given_index {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        System.out.println(Arrays.toString(insatind(arr, 3, 6)));
    }
    static int[]  insatind(int[] array, int position, int element){
        int[] newArr = new int[array.length + 1];
        int i = 0, j = 0;
        while(i < newArr.length){
            if(i < position - 1){
                insert(newArr, array, i, j);
                i ++;
                j ++;
            }
            else if(i == position - 1){
                newArr[i] = element;
                i ++;
            }
            else{
                insert(newArr, array, i, j);
                i ++;
                j ++;
            }
        }
        return newArr;
    }
    static void insert(int[] array1, int[] array2, int index1, int index2){
        array1[index1] = array2[index2];
    }
}
