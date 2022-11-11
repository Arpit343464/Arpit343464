package com.Lab.Lab_7;
import java.util.*;
class BST{
    TreeNode root;
    public BST(){
        this.root = null;
    }
    public void insert(int data){
        root = insert(root, data);
    }
    private TreeNode insert(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }
        else if(data < root.data){
            root.left = insert(root.left, data);
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }
}
public class Q4_BinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        int size;
        System.out.print("Enter the size: ");
        size = sc.nextInt();
        int[] bstArr = new int[size];
        for (int i = 0; i < size; i++) {
            bstArr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(bstArr));
        for (int data: bstArr) {
            bst.insert(data);
        }
        Traversal travel = new Traversal(bst.root);
        travel.InOrder();
    }
}
