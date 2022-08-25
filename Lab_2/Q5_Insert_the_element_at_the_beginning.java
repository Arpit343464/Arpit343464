package com.Lab.Lab_2;

import java.util.Arrays;

public class Q5_Insert_the_element_at_the_beginning {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9};
        System.out.println(Arrays.toString(insatend(arr, 55)));
        myFunctions cp = new myFunctions();
    }
    static int[]  insatend(int[] array, int element){
        int[] newArr = new int[array.length + 1];
        newArr[0] = element;
        myFunctions cp = new myFunctions();
        cp.copy(array, newArr, 0, 1);
        return newArr;
    }
}
