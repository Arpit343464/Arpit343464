package com.Lab.Lab_1;

public class Q5_Return_the_product_of_arr_element {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6};
        int ans = prodArray(arr.length-1, arr);
        System.out.println(ans);
    }
    static int prodArray(int n, int[] arr){
        if(n == -1){
            return 1;
        }
        return prodArray(n-1, arr)*arr[n];
    }
}
