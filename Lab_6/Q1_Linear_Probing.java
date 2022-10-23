package com.Lab.Lab_6;

import java.util.Arrays;
import java.util.Scanner;

class Liner_Probing{

    int M;
    int[] hashArray;
    int[] keys;

    public Liner_Probing(int M, int[] keys){
        this.M = M;
        this.keys = keys;
        this.hashArray = new int[M];
        for (int key: keys) {
            int index = key % M;
            int flag = 0;
            while(hashArray[index] != 0){
                index ++;
                if(index == M){
                    index = 0;
                }
                if(index == (key % M)){
                    M = 2*M;
                    Liner_Probing newHash = new Liner_Probing(M, keys);
                    setHashArray(newHash.hashArray);
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            hashArray[index] = key;
        }

    }
    public void setHashArray(int[] hashArray){
        this.hashArray = hashArray;
    }
    public int[] getHashArray(int[] hashArray){
        return hashArray;
    }

    public int search(int key){
        int index = key % M;
        while(hashArray[index] != 0){
            if(hashArray[index] == key){
                return index;
            }
            index++;
            if(index >= M){
                index = 0;
            }
            if(index == (key % M) - 1){
                return -1;
            }
        }
        return -1;
    }
    public void print(){
        System.out.println(Arrays.toString(getHashArray(hashArray)));
    }
}
public class Q1_Linear_Probing {
    public static void main(String[] args) {
        int[] keys = {133, 88, 92, 221, 174};
        Liner_Probing M1 = new Liner_Probing(17, keys);
        Liner_Probing M2 = new Liner_Probing(37, keys);
        M1.print();
        M2.print();
        Scanner sc = new Scanner(System.in);
        int key;
        while(sc.hasNextInt() && (key = sc.nextInt()) != 0){
            System.out.println("Index of key in Object M1 "+ key + " is "+ M1.search(key));
            System.out.println("Index of key in Object M2 "+ key + " is "+ M2.search(key));
        }
    }
}
