package com.Lab.Lab_2;

public class Q11_Append_the_element_in_doubly_linked_list {
    public static void main(String[] args) {
        Node_Returns n1 = new Node_Returns(1);
        Node_Returns n2 = new Node_Returns(6);
        Node_Returns n3 = new Node_Returns(22);
        Node_Returns n4 = new Node_Returns(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.prev = n3;
        n3.prev = n2;
        n2.prev = n1;
        DoublyLL dll = new DoublyLL(null);
        dll.dubbly_append(dll, 6);
        dll.display();
    }
}
