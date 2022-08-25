package com.Lab.Lab_2;

import java.util.LinkedList;

public class linkedList {
    Node head;

    public linkedList(Node head){
        this.head = head;
    }

    //6. Search the element
    public int Isrch(linkedList linked_list, int element){
        int count = 0;
        Node temp = linked_list.head;
        while(temp.next != null){
            if(temp.value == element){
                return count + 1;
            }
            temp = temp.next;
            count ++;
        }
        return -1;
    }

    //7. Insert the element at last Index
    public void linsatend(linkedList linked_list, int element){
        Node n = new Node(element);
        if(linked_list.head == null){
            linked_list.head = n;
        }
        Node node = linked_list.head;
        while(node.next != null){
             node = node.next;
        }
        node.next = n;
        n.next = null;
    }

    //8a. Insert the element at beginning
    public void linsatbeg(linkedList linked_list, int element){
        Node n1 = new Node(element);
        if(linked_list.head == null){
            linked_list.head = n1;
            return;
        }
        n1.next = linked_list.head;
       linked_list.head = n1;
    }

    //8b. Delete last element
    public void delatend(linkedList linked_list) {
        if(linked_list.head == null){
            return;
        }
        if(linked_list.head.next == null){
            linked_list.head = null;
            return;
        }
        Node temp = linked_list.head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    //10. Replace the value at specified position
    public void replatind(linkedList linked_list, int position, int element){
        int count = 1;
        Node temp = linked_list.head;
        while(count != position){
            temp = temp.next;
            count ++;
        }
        temp.value = element;
    }

    //Display
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

}
class Node{
     int value;
     Node next;

    public Node (int value){
        this.value = value;
    }
}

