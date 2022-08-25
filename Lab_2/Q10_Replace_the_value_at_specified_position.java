package com.Lab.Lab_2;

public class Q10_Replace_the_value_at_specified_position {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        linkedList list = new linkedList(n1);
        list.replatind(list, 3, 6);
        list.display();
    }
}
