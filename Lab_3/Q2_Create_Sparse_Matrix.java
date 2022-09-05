package com.Lab.Lab_3;
import  java.util.Arrays;
public class Q2_Create_Sparse_Matrix {
    public static void main(String[] args) {
        Sparse_matrix sp = new Sparse_matrix(3, 3);
        sp.createMatrix();
        sp.display();

        System.out.println(sp.numRow());

        System.out.println(sp.numCol());

        System.out.println("\nElement At index ["+ 1 +"]["+ 2 +"] is "+sp.getItem(1, 2));
        System.out.println("\nElement At index ["+ 3 +"]["+ 3 +"] is "+sp.getItem(3, 3));

        sp.clear(4);
        sp.display();

        sp.setItem(1, 2, 18);
        sp.display();
    }
}
