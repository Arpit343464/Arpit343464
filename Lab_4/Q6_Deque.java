package com.Lab.Lab_4;

public class Q6_Deque {

    Node front;
    Node rear;
    int count = 0;

    void frontEnqueue(int data){
        Node newNode  = new Node(data);
        if(isEmpty()){
            rear = newNode;
            front = rear;
            count ++;
            return;
        }
        Node temp = front;
        front = newNode;
        front.next = temp;
        front.next.prev = front;
        front.prev = null;
        count ++;
    }

    void rearEnqueue(int data){
        Node newNode  = new Node(data);
        if(isEmpty()){
            front = newNode;
            rear = front;
            count ++;
            return;
        }
        Node temp = rear;
        rear = newNode;
        rear.prev = temp;
        rear.prev.next = rear;
        rear.next = null;
        count ++;
    }

    void frontDequeue(){
        if(isEmpty()){
            return;
        }
        if(front == rear){
            front = null;
            rear = null;
            count = 0;
            return;
        }
        front = front.next;
        count --;
    }

    void rearDequeue(){
        if(isEmpty()){
            return;
        }
        if(front == rear){
            front = null;
            rear = null;
            count = 0;
            return;
        }
        rear = rear.prev;
        count --;
    }

    int front(){
        if(isEmpty()){
            return 0;
        }
        return front.data;
    }

    int rear(){
        if(isEmpty()){
            return 0;
        }
        return rear.data;
    }

    int size(){
        return count;
    }

    boolean isEmpty(){
        if(front == null){
            return true;
        }
        return false;
    }
    void display(){
        System.out.println();
        if(isEmpty()){
            System.out.println("*******Queue is empty now*******");
            return;
        }
        if(front == rear){
            System.out.println("Front <-- " + front.data + " --> Rear");
            return;
        }
        Node temp = front;
        while (temp != null){
            if (temp == front){
                System.out.print("Front <-- " + temp.data);
            }
            else if(temp == rear){
                System.out.print(" <--> " + temp.data + " --> Rear");
                break;
            }
            else{
                System.out.print(" <--> " + temp.data);
            }
            temp = temp.next;
        }
    }
    class Node{
        Node next;
        Node prev;
        int data;
        public Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Q6_Deque deq = new Q6_Deque();
        System.out.println("\nIs Queue is empty? " + deq.isEmpty());
        deq.frontEnqueue(5);
        deq.frontEnqueue(4);
        deq.frontEnqueue(3);
        deq.frontEnqueue(2);
        deq.frontEnqueue(1);
        deq.rearEnqueue(6);
        deq.rearEnqueue(7);
        deq.rearEnqueue(8);
        deq.rearEnqueue(9);
        deq.rearEnqueue(10);
        deq.rearEnqueue(11);
        deq.rearEnqueue(12);
        deq.rearEnqueue(13);
        deq.rearEnqueue(14);
        deq.display();
        System.out.println("\nIs Queue is empty? " + deq.isEmpty());
        System.out.println("\nSize of Queue is " + deq.size());
        System.out.println("\nFront of Queue is " + deq.front());
        System.out.println("\nRear of Queue is " + deq.rear());
        deq.frontDequeue();
        deq.frontDequeue();
        deq.rearDequeue();
        deq.rearDequeue();
        deq.rearDequeue();
        deq.rearDequeue();
        deq.frontDequeue();
        deq.rearDequeue();
        deq.display();
        System.out.println("\nIs Queue is empty? " + deq.isEmpty());
        System.out.println("\nSize of Queue is " + deq.size());
        System.out.println("\nFront of Queue is " + deq.front());
        System.out.println("\nRear of Queue is " + deq.rear());
    }
}
