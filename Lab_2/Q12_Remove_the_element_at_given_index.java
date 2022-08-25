package com.Lab.Lab_2;

public class Q12_Remove_the_element_at_given_index {
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
        DoublyLL dll = new DoublyLL(n1);
        dll.dubbly_remove(dll, 1);
        dll.display();
    }
}
