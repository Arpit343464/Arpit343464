package com.Lab.Lab_2;

public class DoublyLL {
    Node_Returns head;

    public DoublyLL(Node_Returns head){
        this.head = head;
    }

    //11. Append the element in doubly linked list
    public void  dubbly_append(DoublyLL dlinked_list, int element){
        Node_Returns n = new Node_Returns(element);
        if(dlinked_list.head == null){
            dlinked_list.head = n;
            return;
        }
        Node_Returns temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
    }

    //12. Remove the element at given index
    public void dubbly_remove(DoublyLL dlinked_list, int element){
        if(dlinked_list.head == null){
            return;
        }
        Node_Returns temp = head;
        if(dlinked_list.head.value == element){
            dlinked_list.head = temp.next;
            temp.prev = null;
            return;
        }
        while(temp.value != element){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
    public void display(){
        Node_Returns temp = head;
        while(temp != null){
            System.out.print(temp.value + " <--> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

}
class Node_Returns{
    int value;
    Node_Returns next;
    Node_Returns prev;
    public Node_Returns(int value){
        this.value = value;
    }
}
