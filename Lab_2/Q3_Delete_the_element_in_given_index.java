package com.Lab.Lab_2;

import java.util.Arrays;

public class Q3_Delete_the_element_in_given_index {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        System.out.println(Arrays.toString(delatind(arr, 5)));
    }
    static int[] delatind(int[] array, int position){
        if(position <= 0 || position > array.length){
            return array;
        }
        delete(array, position );
        int[] newArr = new int[array.length - 1];
        copy(array, newArr, 0);
        return newArr;
    }
    static void delete(int[] array, int i){
        if (i >= array.length){
            return;
        }
        array[i - 1] = array[i];
        i++;
        delete(array, i);
    }
    static void copy(int[] arr1, int[] arr2, int index){
        if(index < arr2.length){
            arr2[index] = arr1[index];
            index ++;
            copy(arr1, arr2, index);
        }
    }
}