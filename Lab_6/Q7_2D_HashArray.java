package com.Lab.Lab_6;

import java.util.Arrays;
import java.util.Scanner;

class hash2DArray{

    int M;
    int hashArray[][];
    int[] keys;

    public hash2DArray(int M, int[] keys){
        this.M = M;
        this.hashArray = new int[M][M];
        this.keys = keys;
        int flag = 0;
        for (int key: keys) {
            int index = key % M;
            int i = 0;
            while(hashArray[index][i] != 0){
                i++;
                if(i == M){
                    M = M*2;
                    hash2DArray newHash = new hash2DArray(M, keys);
                    setHashArray(newHash.hashArray);
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            hashArray[index][i] = key;
        }
    }

    public void setHashArray(int[][] hashArray) {
        this.hashArray = hashArray;
    }

    public int[][] getHashArray() {
        return hashArray;
    }

    public void print(){
        System.out.println(Arrays.deepToString(getHashArray()));
    }
    public int[] search(int key){
        int index = key % M;
        int i = 0;
        int[] ans = {index, i};
        while(hashArray[index][i] != 0){
            if(hashArray[index][i] == key){
               ans[0] = index;
               ans[1] = i;
               break;
            }
            i++;
            if(i == M){
                ans[0] = -1;
                ans[1] = -1;
                break;
            }
        }
        return ans;
    }
}
public class Q7_2D_HashArray {
    public static void main(String[] args) {
        int[] keys = {34, 56, 25, 76, 58, 97, 52, 75, 19, 30, 48, 67, 73};
        hash2DArray M1 = new hash2DArray(4, keys);
        M1.print();
        Scanner sc = new Scanner(System.in);
        int key;
        while(sc.hasNext() && (key = sc.nextInt()) != 0){
            System.out.println("Index of key in Object M1 "+ key + " is "+ Arrays.toString(M1.search(key)));
        }
    }
}
