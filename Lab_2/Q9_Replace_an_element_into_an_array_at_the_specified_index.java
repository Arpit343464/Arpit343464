package com.Lab.Lab_2;

import java.util.Arrays;

public class Q9_Replace_an_element_into_an_array_at_the_specified_index {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(replatind(arr, 6, 6)));
    }
    static int[] replatind(int[] array, int position, int element){
        if(position > array.length || position <= 0){
            System.out.println(-1);
            return array;
        }
        array[position - 1] = element;
        return array;
    }
}
