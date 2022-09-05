package com.Lab.Lab_3;

import java.util.Arrays;

public class Q3_Create_Sparse_matrix_2 {
    public static void main(String[] args) {
        Sparse_matrix sp = new Sparse_matrix(2, 5);
        sp.createMatrix();
        sp.display();

        System.out.println(sp.numRow());

        System.out.println(sp.numCol());

        System.out.println("\nElement At index ["+ 1 +"]["+ 2 +"] is "+sp.getItem(1, 2));
        System.out.println("\nElement At index ["+ 3 +"]["+ 3 +"] is "+sp.getItem(3, 3));

        sp.setItem(1, 3, 18);
        sp.display();

        sp.scaleBy(2);
        sp.display();

        System.out.println("\nTranspose of sparse matrix");
        sp.display1(sp.transpose());

        System.out.println("\nAddition of sparse matrix");
        sp.display1(sp.add(sp.createForAddAndSubtract()));

        System.out.println("\nSubtraction of sparse matrix");
        sp.display1(sp.subtract(sp.createForAddAndSubtract()));

        System.out.println("\nMultiplication of sparse matrix");
        sp.display1(sp.multiply(sp.createForMultiplication(3)));
    }
}
