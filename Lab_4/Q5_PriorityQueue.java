package com.Lab.Lab_4;

import java.util.Arrays;

public class Q5_PriorityQueue {
    Node front;
    int[] arr;
    int length = 0, flag;
    void enqueue(int data, int priority){
        Node newNode = new Node(data, priority);
        if(priority <= 0){
            newNode.priority = 1;
        }
        if(isEmpty()){
            front = newNode;
            front.next = null;
            length ++;
            return;
        }
        sort(newNode);
        length ++;
    }

    void sort(Node node){
        if(node.priority <= front.priority){
            Node sweep = front;
            front = node;
            front.next = sweep;
        }
        else{
            Node temp = front;
            flag = 0;
            while (temp.next != null){
                if(node.priority <= temp.next.priority){
                    Node sweep = temp;
                    temp = node;
                    temp.next = sweep.next;
                    sweep.next = temp;
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
            if(flag == 0){
                Node sweep = temp;
                temp = node;
                temp.next = null;
                sweep.next = temp;
            }
        }
    }

    void dequeue(){
        if (isEmpty()){
            return;
        }
        System.out.println("priority: " + front.priority + "\t\t\tData: " + front.data);
        front = front.next;
        length --;
    }
    boolean isEmpty(){
        if(front == null){
            return true;
        }
        return false;
    }

    int size(){
        if(isEmpty()){
            return 0;
        }
        return length;
    }
    void display(){
        System.out.println("Priority   Data");
        Node temp = front;
        while(temp != null){
            System.out.println(temp.priority + "\t\t\t" + temp.data);
            temp = temp.next;
        }
    }
    class Node{
        int data;
        int priority;
        Node front;
        Node next;
        public Node(int data, int priority){
            this.data = data;
            this.priority = priority;
        }
    }
    public static void main(String[] args) {
        Q5_PriorityQueue pq = new Q5_PriorityQueue();
        pq.enqueue(45, 3);
        pq.enqueue(34, 2);
        pq.enqueue(28, 1);
        pq.enqueue(42, 2);
        pq.enqueue(98, 6);
        pq.enqueue(86, 3);
        pq.dequeue();
        pq.dequeue();
        pq.dequeue();
        pq.dequeue();
        pq.display();
    }
}
