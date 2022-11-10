package com.Lab.Lab_7;
import java.util.Arrays;
import java.util.ArrayList;
class heap{
    int[] arr;
    ArrayList<Integer> heapArray;
    public heap(int[] arr){
        this.arr = arr;
    }
    public void minHeapSort(){
        heapArray = convertToArrList(arr);
        for(int i = heapArray.size()/2 - 1; i >=0; i --){
            heapify(heapArray, heapArray.size(), i);
        }
        print(heapArray);
    }
    private ArrayList<Integer> convertToArrList(int[] arr){
        ArrayList<Integer> heapArr = new ArrayList<>();
        for (int a: arr) {
            heapArr.add(a);
        }
        return heapArr;
    }
    private void heapify(ArrayList<Integer> arr, int N, int oldSmallest){
        int newSmallest = oldSmallest;
        int left = 2*oldSmallest + 1;
        int right = 2*oldSmallest + 2;

        if(left < N && arr.get(left) < arr.get(newSmallest)){
            newSmallest = left;
        }
        if(right < N && arr.get(right) < arr.get(newSmallest)){
            newSmallest = right;
        }
        if(newSmallest != oldSmallest){
            swap(arr, oldSmallest, newSmallest);
            heapify(arr, N, newSmallest);
        }
    }
    public void insert(int data){
        heapArray.add(data);
        int newData = heapArray.size() - 1;
        int correctPlace = (newData + 1)/2 - 1;
        while(heapArray.get(newData) < heapArray.get(correctPlace)){
            heapify(heapArray, heapArray.size(), correctPlace);
            newData = correctPlace;
            correctPlace = (newData + 1)/2 - 1;
            if(correctPlace < 0 || newData < 0){
                break;
            }
        }
    }
    public void extract(){
        heapArray.set(0, heapArray.get(heapArray.size()-1));
        heapArray.remove(heapArray.size() - 1);
        heapify(heapArray, heapArray.size(), 0);
    }
    public int getMin(){
        return heapArray.get(0);
    }
    private void swap(ArrayList<Integer> arr, int oldSmallest, int newSmallest){
        int temp = arr.get(oldSmallest);
        arr.set(oldSmallest, arr.get(newSmallest));
        arr.set(newSmallest, temp);
    }
    public void print(ArrayList<Integer> heapArr){
        System.out.print("[");
        int i = 0;
        while(i != heapArr.size() - 1){
            System.out.print(heapArr.get(i) + ", ");
            i++;
        }
        System.out.print(heapArr.get(i) + "]\n");
    }
}
public class Q3_MinHeapSort {
    public static void main(String[] args) {
        int[] heapArray = {14, 12, 10, 19, 23, 9, 8, 16, 6};
        heap h = new heap(heapArray);
        h.minHeapSort();
        h.insert(28);
        h.insert(13);
        h.insert(7);
        h.insert(1);
        h.print(h.heapArray);
        h.extract();
        h.print(h.heapArray);
        System.out.println("Minimum element is " + h.getMin());
        h.extract();
        h.print(h.heapArray);
        h.extract();
        h.print(h.heapArray);
    }
}
