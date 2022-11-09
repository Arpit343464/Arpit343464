package com.Lab.Lab_7;

class BreadthFirstSearch{
    node root;
    public BreadthFirstSearch(node root){
        this.root = root;
    }
    public void BFS(){
        queues q = new queues();
        q.enqueue(root);
        System.out.print("[");
        BFS(q);
        System.out.println("]");
    }
    public void BFS(queues q){
        node nodeBar = q.dequeue();
        System.out.print(nodeBar.data + ", ");
        for (int i = 0; i < nodeBar.size; i++) {
            q.enqueue(nodeBar.nodes[i]);
        }
        if(q.size == 1){
            System.out.print(nodeBar.next.data);
            return;
        }
        if(!q.isEmpty(q.size)){
            BFS(q);
        }

    }
}
class node{
    node[] nodes;
    node next;
    int data;
    int size;
    public node(int data){
        this.data = data;
    }
    public void nodes(int size, node ... Node){
        this.size = size;
        nodes = new node[size];
        int i = 0;
        for (node node: Node) {
            nodes[i] = node;
            i ++;
        }
    }
}
public class Q2_BreadthFirstSearch {
    public static void main(String[] args) {
        node A = new node(5);
        node B = new node(1);
        node C = new node(2);
        node D = new node(3);
        node E = new node(3);
        node F = new node(6);
        node G = new node(7);
        node H = new node(7);
        node I = new node(8);
        node J = new node(9);
        A.nodes(3, B, C, D);
        B.nodes(1, E);
        C.nodes(2, F, G);
        D.nodes(3, H, I, J);
        BreadthFirstSearch bfs = new BreadthFirstSearch(A);
        bfs.BFS();
    }
}