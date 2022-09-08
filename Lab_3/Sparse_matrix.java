package com.Lab.Lab_3;

import java.util.Arrays;
import java.util.Scanner;

public class Sparse_matrix {
    private int nRow;
    private int nCol;
    private int nCOL;
    private int data;
    private int scalar;
    private int[][] sparseArr;
    private int[][] transpose;
    private int[][] Matrix;
    private int[][] addition;
    private int[][] subtraction;
    private int[][] Multiplication;

    public Sparse_matrix(int nRow, int nCol){
        this.nRow = nRow;
        this.nCol = nCol;
        this.sparseArr = new int[nRow][nCol];
    }
    public void createMatrix(){
        Scanner sc = new Scanner(System.in);
        int count = 0, flag = 0;
        do{
            System.out.print("\nEnter Row Column And element: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            int element = sc.nextInt();
            count++;
            setItem(row, col, element);
            if(count >= nRow*nCol/3){
                break;
            }
            System.out.print("Are you want to add non zero element? yes(press 1) / no(press 0): ");
            choice = sc.nextInt();
        }while(choice != 0);
        System.out.println("\nSparse Matrix is created");
    }

    public int[][] createForAddAndSubtract(){
        Scanner sc = new Scanner(System.in);
        this.Matrix = new int[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                System.out.printf("matrix[%d][%d] = ",i,j);
                int element = sc.nextInt();
                setItem1(i, j, element, Matrix);
            }
        }
        return Matrix;
    }
    public int[][] createForMultiplication(int nCOL){
        this.nCOL = nCOL;
        Scanner sc = new Scanner(System.in);
        this.Matrix = new int[nCol][nCOL];
        for (int i = 0; i < nCol; i++) {
            for (int j = 0; j < nCOL; j++) {
                System.out.printf("matrix[%d][%d] = ",i,j);
                int element = sc.nextInt();
                setItem1(i, j, element, Matrix);
            }
        }
        return Matrix;
    }

    public int numRow(){

        System.out.print("\nNumber of Row is: ");
        return nRow;
    }

    public int numCol(){
        System.out.print("\nNumber of Column is: ");
        return nCol;
    }

    public void clear(int data){
        System.out.println("After Clear the Matrix by "+data);
        this.data = data;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                setItem(i, j, data);
            }
        }
    }
    public int getItem(int row, int col){

        try{
            return sparseArr[row][col];
        }
        catch(Exception e){
            return -1;
        }
    }

    public void setItem(int row, int col, int data){
        this.data = data;
        if(data == 0){
            return;
        }
        try{
            sparseArr[row][col] = data;
        }
        catch(Exception e){
            System.out.println("\nArray Index Out Of Bounds");
        }
    }

    public void setItem1(int row, int col, int data, int[][] Matrix){
        this.data = data;
        this.Matrix = Matrix;
        try{
            Matrix[row][col] = data;
        }
        catch(Exception e){
            System.out.println("\nArray Index Out Of Bounds");
        }
    }

    public void scaleBy(int scalar){
        System.out.print("\nAfter Scalar Multiplication with "+scalar);
        this.scalar = scalar;
        if(scalar == 0){
            return;
        }
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                sparseArr[i][j] = scalar*getItem(i, j);
            }
        }
    }

    public int[][] transpose(){
        this.transpose = new int[nCol][nRow];
        for (int i = 0; i < nCol; i++) {
            for (int j = 0; j < nRow; j++) {
                transpose[i][j] = sparseArr[j][i];
            }
        }
        return transpose;
    }

    public int[][] add(int[][] Matrix){
        this.addition = new int[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                addition[i][j] = sparseArr[i][j] + Matrix[i][j];
            }
        }
        return addition;
    }

    public int[][] subtract(int[][] Matrix){
        this.subtraction = new int[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                subtraction[i][j] = sparseArr[i][j] - Matrix[i][j];
            }
        }
        return subtraction;
    }

    public int[][] multiply(int[][] Matrix){
        this.Multiplication = new int[nRow][nCOL];
        for (int i = 0; i < nRow; i++) {
            for (int k = 0; k < nCOL; k++) {
                Multiplication[i][k] = 0;
                for (int j = 0; j < nCol; j++) {
                    Multiplication[i][k] += sparseArr[i][j] * Matrix[j][k];
                }
            }
        }
        return Multiplication;
    }

    public void display(){
        System.out.println();
        for (int [] a: sparseArr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
    public void display1(int[][] matrix){
        System.out.println();
        for (int[] a: matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
}
