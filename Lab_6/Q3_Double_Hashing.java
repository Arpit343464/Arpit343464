package com.Lab.Lab_6;
import java.util.Scanner;
import java.util.Arrays;
class doubleHash{

    int M;
    int P;
    int[] hashArray;
    int[] keys;
    int home;
    int hp;

    public doubleHash(int M, int P, int[] keys){
        this.M = M;
        this.P = P;
        this.keys = keys;
        this.hashArray = new int[M];
        if(ratio(keys, M) > 80){
            M = 2*M + 1;
            doubleHash newHash = new doubleHash(M, P, keys);
            setHashArray(newHash.hashArray);
            return;
        }
        for (int key: keys) {
            this.home = key % M;
            this.hp = 1 + (key % P);
            add(home, hp, key, hashArray);
        }
    }
    public float ratio(int[] keys, int M){
        return (keys.length * 100) / M;
    }
    public void add(int home, int hp, int key, int[] hashArray){
        int i = 0;
        int count = 0;
        int flag = 0;
        int index = home + i*hp;
        while(hashArray[index] != 0){
            i++;
            index = home + i*hp;
            if(index >= home && count > 0){
                home = home + 1;
                if(home == M){
                    home = 0;
                }
                add(home, hp, key, hashArray);
                flag = 1;
                break;
            }
            if(index >= M){
                index = index - M;
                count++;
            }
        }
        if(flag == 0){
            hashArray[index] = key;
        }
    }

    public void setHashArray(int[] hashArray) {
        this.hashArray = hashArray;
    }

    public int[] getHashArray() {
        return hashArray;
    }

    public void print(){
        System.out.println(Arrays.toString(getHashArray()));
    }

    public int search (int key){
        int home = key % M;
        int hp = 1 + key % P;
        int index = inplace(home, hp, key);
        return index;
    }

    public int inplace(int home, int hp, int key){
        int i = 0;
        int count = 0;
        int index = home + i*hp;
        while(hashArray[index] != key){
            i++;
            index = home + i*hp;
            if(index > home && count > 0){
                home = home + 1;
                if(home == M){
                    home = 0;
                }
                return inplace(home, hp, key);
            }
            if(index >= M){
                index = index - M;
                count ++;
            }
            if(home == (key % M) - 1){
                return -1;
            }
        }
        return index;
    }
}
public class Q3_Double_Hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] keys = {133, 88, 92, 221, 174};
        doubleHash M1 = new doubleHash(17, 11, keys);
        M1.print();
        int key;
        while(sc.hasNext() && (key = sc.nextInt()) != 0){
            System.out.println("Index of key "+ key +" in object M1 is "+ M1.search(key));
        }
    }
}