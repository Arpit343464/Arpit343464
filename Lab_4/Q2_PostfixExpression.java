package com.Lab.Lab_4;

public class Q2_PostfixExpression {
    static int prec(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static boolean isDigitOrLetter(char c){
        if(((int)c >= 65 && (int)c <= 90) || ((int)c >= 97 && (int)c <= 122) || ((int)c >= 48 && (int)c <= 57)){
            return true;
        }
        return false;
    }
    static String infixToPostfix(String s) {
        Q1_Stacks S = new Q1_Stacks();
        String result = new String("");
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(isDigitOrLetter(c)){
                result += c + " ";
            } else if (c == '(') {
                S.push(c);
            } else if (c == ')') {
                while(!S.isEmpty() && S.peek() != '('){
                    result += S.peek() + " ";
                    S.popChar();
                }
                S.popChar();
            }
            else{
                while(!S.isEmpty() && prec(c) <= prec(S.peek())){
                    result += S.peek() + " ";
                    S.popChar();
                }
                S.push(c);
            }
        }
        while(!S.isEmpty()){
            if(S.peek() == '('){
                return "Invalid Expression";
            }
            result += S.peek() + " ";
            S.popChar();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "4+8*2^3-7*2";
        System.out.println(infixToPostfix(s));
    }
}