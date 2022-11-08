package com.Lab.Lab_7;
import java.util.*;
class Traversal{
    TreeNode root;
    public Traversal(TreeNode root){
        this.root = root;
    }
    public void InOrder(){
        if(root == null){
            System.out.println("[]");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> travel = new ArrayList<>();
        System.out.println("InOrder Traversal: ");
//        System.out.print("[ ");
        TreeNode count = root;
        while(count != null || s.size() > 0){
            while(count != null){
                s.push(count);
                count = count.left;
            }
            count = s.pop();
            travel.add(count.data);
//            System.out.print(count.data + " ");
            count = count.right;
        }
//        System.out.print("]\n");
        print(travel);
    }
    public void PreOrder(){
        if(root == null){
            System.out.println("[]");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> travel = new ArrayList<>();
        System.out.println("PreOrder Traversal: ");
//        System.out.print("[ ");
        TreeNode count = root;
        while(count != null || s.size() > 0){
            while(count != null){
                travel.add(count.data);
//                System.out.print(count.data + " ");
                s.push(count);
                count = count.left;
            }
            count = s.pop();
            count = count.right;
        }
//        System.out.print("]\n");
        print(travel);
    }
    public void PostOrder(){
        if(root == null){
            System.out.println("[]");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> travel = new ArrayList<>();
        System.out.println("PostOrder Traversal: ");
//        System.out.print("[ ");
        TreeNode count = root;
        while(count != null || s.size() > 0){
            while(count != null){
                if(count.right != null){
                    s.push(count.right);
                    s.push(count);
                    s.peek();
                    count = count.left;
                }
                else{
                    s.push(count);
                    count = count.left;
                }
            }
            while(count == null){
                count = s.pop();
                if(s.size() == 0){
                    travel.add(count.data);
//                    System.out.print(count.data + " ");
                    count = null;
                    break;
                }
                if(count.right != s.peek()){
                    travel.add(count.data);
//                    System.out.print(count.data + " ");
                    count = null;
                }
                else{
                    TreeNode temp = s.pop();
                    s.push(count);
                    count = temp;
                }
            }
        }
//        System.out.print("]");
        print(travel);
    }
    public void print(ArrayList<Integer> travel){
        System.out.print("[");
        for (int i = 0; i < travel.size(); i++) {
            if(i == travel.size() - 1){
                System.out.print(travel.get(i) + "]\n");
            }
            else{
                System.out.print(travel.get(i) + ", ");
            }
        }
    }
}
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
    }
    public void left(TreeNode left){
        this.left = left;
    }
    public void right(TreeNode right){
        this.right = right;
    }
}
public class Q1_TraversalOfTree {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        TreeNode I = new TreeNode(9);
        TreeNode J = new TreeNode(10);
        A.left(B);
        A.right(C);
        B.left(D);
        B.right(E);
        C.left(F);
        C.right(G);
        D.right(H);
        F.right(I);
        G.left(J);
        Traversal tree = new Traversal(A);
        tree.InOrder();
        tree.PreOrder();
        tree.PostOrder();
    }
}
