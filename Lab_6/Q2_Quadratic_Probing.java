package com.Lab.Lab_6;

import java.util.Arrays;
import java.util.Scanner;

class Quadratic_Probing{

    int M;
    int[] hashArray;
    int[] keys;

    public Quadratic_Probing(int M, int[] keys){
        this.M = M;
        this.keys = keys;
        this.hashArray = new int[M];
        for (int key: keys) {
            int home = key % M;
            int index = home;
            int flag = 0;
            int count = 1;
            while(hashArray[index] != 0){
                int place = index + count*count;
                if(place >= M){
                    index++;
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

    public void print(){
        System.out.println(Arrays.toString(getHashArray(hashArray)));
    }

    public int search(int key){
        int home = key % M;
        int index = home;
        int i = 1;
        int count = 0;
        while(keys[index] != 0){
            index = index + i*i;
            i++;

            if(index > M && count > 0){
                home ++;
            }
            if(index > M){
                index = index - M;
                count++;
            }
        }
        return 0;
    }
}
public class Q2_Quadratic_Probing {
    public static void main(String[] args) {
        int[] keys = {133, 88, 92, 221, 174};
        Quadratic_Probing M1 = new Quadratic_Probing(3, keys);
        Quadratic_Probing M2 = new Quadratic_Probing(8, keys);
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
