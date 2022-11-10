package com.Lab.Lab_7;

public class queues {
    node node;
    node head;
    node tail;
    int size = 0;
    public void enqueue(node root){
        node = root;
        if(isEmpty(size)){
            head = tail = node;
            size ++;
            return;
        }
        if(size == 1){
            tail = node;
            head.next = tail;
            size ++;
            return;
        }
        node temp = tail;
        tail = node;
        temp.next = tail;
        size ++;
    }
    public node dequeue(){
        if(isEmpty(size)){
            return null;
        }
        node temp = head;
        head = temp.next;
        size --;
        return temp;
    }
    public boolean isEmpty(int size) {
        if (size == 0) {
            return true;
        }
        return false;
    }
}

