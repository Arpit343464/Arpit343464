package com.Lab.Lab_4;

public class Q1_Stacks {
    Node top;
    Node peek;
    int count = 0;
    void push(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
            top.next = null;
            count ++;
            return;
        }
        Node temp = top;
        top = newNode;
        top.next= temp;
        count ++;
    }

    public void push(char c){
        Node newNode = new Node(c);
        if(peek == null){
            peek = newNode;
            peek.next = null;
            count ++;
            return;
        }
        Node temp = peek;
        peek = newNode;
        peek.next = temp;
        count ++;
    }

    void popInt(){
        if(top == null){
            return;
        }
        top = top.next;
        count --;
    }

    void popChar(){
        if(peek == null){
            return;
        }
        peek = peek.next;
        count --;
    }

    boolean isEmpty(){
        if(top == null && peek == null){
            return true;
        }
        return false;
    }

    int top(){
        if(isEmpty()){
            return 0;
        }
        return top.data;
    }

    char peek(){
        if(isEmpty()){
            return 0;
        }
        return peek.c;
    }
    int size(){
        this.count = count;
        return count;
    }

    void display(){
        System.out.println();
        if(top == null){
            System.out.println("Stack is Null");
            return;
        }
        Node temp = top;
        while(temp != null){
            if(temp == top){
                System.out.println(temp.data + " --> Top");
                temp = temp.next;
                continue;
            }
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    static class Node{
        int data;
        char c;
        Node next;
        public Node(int data){
            this.data =  data;
        }
        public Node(char c){
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Q1_Stacks stack = new Q1_Stacks();
        System.out.println("Is stack isEmpty? " + stack.isEmpty());
        stack.push(5);
        stack.push(1);
        stack.push(9);
        stack.push(3);
        stack.push(8);
        stack.push(4);
        stack.push(7);
        stack.display();
        System.out.println("\nIs stack isEmpty? " + stack.isEmpty());
        System.out.println("\nTop of the stack is " + stack.top());
        System.out.println("\nSize of the stack is " + stack.size());

        stack.popInt();
        stack.popInt();
        stack.popInt();
        stack.display();
        System.out.println("\nTop of the stack is " + stack.top());
        System.out.println("\nSize of the stack is " + stack.size());
    }
}

