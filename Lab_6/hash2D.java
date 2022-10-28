package com.Lab.Lab_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class hash2D {
    int crashValue;
    int newM;
    ArrayList<ArrayList<Integer>> hash2DArray = new ArrayList<ArrayList<Integer>>();
    int[] keys;
    int[] crashServer;

    public hash2D(int M, int crashValue, int[] keys){
        this.crashValue = crashValue;
        this.keys = keys;
        for (int i = 0; i < M; i++) {
            hash2DArray.add(new ArrayList<>());
        }
        System.out.println("Enter the crashServer: ");
        setCrashServer(crashValue);

        //Selection Sort
        sort(crashServer);

        this.newM = M - crashValue;
        for (int key: keys) {
            add(M, newM, key, crashServer, hash2DArray);
        }
    }

    public void setCrashServer(int crashValue){
        Scanner sc = new Scanner(System.in);
        this.crashServer = new int[crashValue];
        for (int i = 0; i < crashValue; i++) {
            crashServer[i] = sc.nextInt();
        }
    }

    public void add(int M, int newM, int key, int[] crashServer, ArrayList<ArrayList<Integer>> hash2DArray){
        int index = key % M;
        //Binary Search
        if(contains(index, crashServer)){
            index = key % newM;
            while(contains(index, crashServer)){
                index ++;
                if(index == M){
                    index = 0;
                }
            }
        }
        hash2DArray.get(index).add(key);
    }

    public void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = min(i, arr);
            swap(i, min, arr);
        }
    }

    public int min(int index, int[] arr){
        int min = index;
        for (int i = index + 1; i < arr.length; i++) {
            if(arr[min] > arr[i]){
                min = i;
            }
        }
        return min;
    }

    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean contains(int target, int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
