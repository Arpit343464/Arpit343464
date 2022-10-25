package com.Lab.Lab_6;
import java.util.Scanner;
import java.util.Arrays;
class hashTable{
    int M;
    int[] hashArray;
    int[] keys;
    public hashTable(int M, int[] keys){
        this.M = M;
        this.keys = keys;
        this.hashArray = new int[M];
        if(ratio(M, keys) >= 80){
            M = 2*M + 1;
            hashTable newHash = new hashTable(M, keys);
            setHashArray(newHash.hashArray);
            return;
        }
        for (int key: keys) {
            int index = key % M;
            hashArray[index] = 1;
        }
    }
    public boolean contains(int key){
        int index = key % M;
        if(hashArray[index] == 0){
            return false;
        }
        return true;
    }
    public float ratio(int M, int[] keys){
        return (keys.length * 100)/M;
    }

    public void setHashArray(int[] hashArray) {
        this.hashArray = hashArray;
    }
}
public class Q4_hashTable {
    public static void main(String[] args) {
        int[] keys = {133, 88, 92, 221, 174};
        hashTable M1 = new hashTable(17, keys);
        hashTable M2 = new hashTable(37, keys);
        int key;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext() && (key = sc.nextInt()) != 0){
            System.out.println("M1 contains key " + key + " : " + M1.contains(key));
            System.out.println("M2 contains key " + key + " : " + M2.contains(key));
        }
    }
}