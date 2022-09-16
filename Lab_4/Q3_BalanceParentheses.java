package com.Lab.Lab_4;

public class Q3_BalanceParentheses {
    Node top;
    private char parentheses;
    private int count = 0;

    public void push(char parentheses){
        Node newNode = new Node(parentheses);
        if(top == null){
            top = newNode;
            top.next = null;
            count ++;
            return;
        }
        Node temp = top;
        top = newNode;
        top.next = temp;
        count ++;
    }

    public void pop(){
        if(top == null){
            count = 0;
            return;
        }
        top = top.next;
        count--;
    }

    public char top(){
        return top.parentheses;
    }

    public int size(){
        return count;
    }

    class Node{
        private char parentheses;
        private Node next;
        public Node(char parentheses){
            this.parentheses = parentheses;
        }
    }
    static boolean isValid(String s) {
        Q1_Stacks cvp = new Q1_Stacks();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '/'){
                break;
            }
            if(cvp.isEmpty()){
                if(s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '[' || s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')'){
                    if(s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '['){
                        cvp.push(s.charAt(i));
                    }
                    else{
                        return false;
                    }
                }
            }
            else{
                char c = ')';
                if(s.charAt(i) == c && (int)c == (int)cvp.peek() + 1){
                    cvp.popChar();
                } else if ((int)s.charAt(i) == (int)cvp.peek() + 2) {
                    cvp.popChar();
                }
            }
        }
        if(cvp.size() == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "(int arr[]) // (this is fun!";
        System.out.println("Is str1 has valid parentheses? " + isValid(str1));
        String str2 = "(int arr[])] // (this is fun!";
        System.out.println("Is str2 has valid parentheses? " + isValid(str2));
    }
}
