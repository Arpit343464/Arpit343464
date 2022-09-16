package com.Lab.Lab_4;

public class Q4_Queues {
    Node front, rear;
    int count = 0;

    void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            rear = newNode;
            front = rear;
            rear.next = null;
            count ++;
            return;
        }
        Node temp = rear;
        rear = newNode;
        temp.next =  rear;
        rear.next =null;
        count ++;
    }

    void dequeue(){
        if(isEmpty()){
            return;
        }
        front = front.next;
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
        if (isEmpty()){
            System.out.println("*******Queue is null*******");
            return;
        }
        if(front == rear){
            System.out.print("Front <-- " + front.data + " --> Rear");
            return;
        }
        Node temp = front;
        while(temp != null){
            if(temp == front){
                System.out.print("Front <-- " + temp.data);
            }
            else if(temp == rear){
                System.out.print(" --> " + temp.data + " --> Rear");
            }
            else{
                System.out.print(" --> " + temp.data);
            }
            temp = temp.next;
        }
    }
    class Node{
        int data;
        Node front;
        Node rear;
        Node next;
        public Node (int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Q4_Queues queues = new Q4_Queues();
        System.out.println("\nQueue is Empty? " + queues.isEmpty());
        queues.enqueue(8);
        queues.enqueue(5);
        queues.enqueue(3);
        queues.enqueue(6);
        queues.enqueue(1);
        queues.enqueue(2);
        queues.enqueue(9);
        queues.enqueue(7);
        queues.enqueue(4);
        queues.display();
        System.out.println("\nSize of Queue is " + queues.size());
        System.out.println("\nQueue is Empty? " + queues.isEmpty());
        System.out.println("\nFront of queue is " + queues.front());
        System.out.println("\nRear of queue is " + queues.rear());
        queues.dequeue();
        queues.dequeue();
        queues.dequeue();
        queues.dequeue();
        queues.dequeue();
        queues.dequeue();
        queues.display();
        System.out.println("\nSize of Queue is " + queues.size());
        System.out.println("\nQueue is Empty? " + queues.isEmpty());
        System.out.println("\nFront of queue is " + queues.front());
        System.out.println("\nRear of queue is " + queues.rear());
        queues.dequeue();
        queues.dequeue();
        queues.dequeue();
        queues.dequeue();
        queues.display();
    }
}

