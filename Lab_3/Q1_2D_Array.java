package com.Lab.Lab_3;

import java.util.Arrays;
import java.util.Scanner;
class Array2D{
    int[][] array;
    int nrow;
    int ncol;

    public Array2D(int nrow, int ncol){
        this.nrow = nrow;
        this.ncol = ncol;
        this.array = new int[nrow][ncol];
    }
    public int numRow(){
        return nrow;
    }
    public int numCol(){
        return ncol;
    }
    public void clear(int value){
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                array[i][j] = value;
            }
        }
    }
    public int getItem(int row, int col){
        if(row >= nrow || col >= ncol){
            System.out.printf("Element at [%d][%d] is ",row,col);
            return - 1;
        }
        System.out.printf("Element at [%d][%d] is ",row,col);
        return array[row][col];
    }

    public void setItem(int row, int col, int value){
        if(row > nrow || col > ncol){
            return;
        }
        array[row][col] = value;
    }
    public void arrow(){
        System.out.print("\n--->");
    }
    public void display(){
        System.out.println();
        for (int i = 0; i < nrow; i++) {
            System.out.print("\t");
            for (int j = 0; j < ncol; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class Q1_2D_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array2D arr = new Array2D(2, 2);
        for (int i = 0; i < arr.nrow; i++) {
            for (int j = 0; j < arr.ncol; j++) {
                System.out.printf("array[%d][%d] = ",i,j);
                int value = sc.nextInt();
                arr.setItem(i, j, value);
            }
        }
        arr.display();
        //numRow
        arr.arrow();
        System.out.println("Number of Row is "+arr.numRow());
        //numCol
        arr.arrow();
        System.out.println("Number of Column is "+arr.numCol());
        //getItem
        arr.arrow();
        System.out.println(arr.getItem(2, 1));
        //clear
        arr.clear(6);
        arr.display();

        //setItem
        arr.setItem(1, 0, 24);
        arr.setItem(0, 1, 67);
        arr.display();
    }

}
