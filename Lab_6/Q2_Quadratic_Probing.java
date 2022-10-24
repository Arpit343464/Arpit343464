package com.Lab.Lab_6;

import java.util.Arrays;
import java.util.Scanner;

class Quadratic_Probing{

    int M;
    int[] hashArray;
    int[] keys;
    int home;

    public Quadratic_Probing(int M, int[] keys){
        this.M = M;
        this.keys = keys;
        this.hashArray = new int[M];

        for (int key: keys) {
            this.home = key % M;
            add(home, key, hashArray);
        }
    }

    public void add(int place, int key, int[] hashArray){
        int i = 0;
        int count = 0;
        int flag = 0;
        int index = place + i*i;
        while(hashArray[index] != 0){
            i++;
            index = place + i*i;
            if(index >= place && count > 0){
                place = place + 1;
                if(place == M){
                    place = 0;
                }
                add(place, key, hashArray);
                flag = 1;
                break;
            }
            if(index >= M) {
                index = index - M;
                count++;
            }
            if(place == home - 1){
                M = M*2;
                Quadratic_Probing newHash = new Quadratic_Probing(M, keys);
                setHashArray(newHash.hashArray);
                break;
            }
        }
        if(flag == 0){
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
        home = key % M;
        int index = inPlace(home, key, hashArray);
        return index;
    }

    public int inPlace(int place, int key, int[] hashArray){
        int i = 0;
        int count = 0;
        int index = place + i*i;
        while(hashArray[index] != key){
            i++;
            index = place + i*i;
            if(index >= M){
                index = index - M;
                count++;
            }
            if(index >= place && count > 0){
                place = place + 1;
                if(place == M){
                    place = 0;
                }
                return inPlace(place, key, hashArray);
            }
            if(place == home - 1){
                return -1;
            }
        }
        return index;
    }
}
public class Q2_Quadratic_Probing {
    public static void main(String[] args) {
        int[] keys = {133, 88, 92, 221, 174};
        Quadratic_Probing M1 = new Quadratic_Probing(17, keys);
        Quadratic_Probing M2 = new Quadratic_Probing(37, keys);
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
