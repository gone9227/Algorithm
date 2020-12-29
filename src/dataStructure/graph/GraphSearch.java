package dataStructure.graph;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class GraphSearch {

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.dfsR();
    }
}

class Queue<T> {
    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T data){
        Node<T> t = new Node<T>(data);
        if(tail != null){
            tail.next = t;
        }
        tail = t;
        if(head == null){
            head = tail;
        }
    }

    public T dequeue(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T item = head.data;
        head = head.next;

        if(head == null){
            tail = null;
        }
        return item;
    }

    public T peek(){
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }
}

class Graph{
    class Node{
        int data;
        boolean marked;
        LinkedList<Node> adjacent;
        public Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for(int i = 0; i < size; i++){
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    void dfs(){
        dfs(0);
    }

    void dfs(int index){
        Node start = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        start.marked = true;
        while (!stack.isEmpty()){
            Node n = stack.pop();
            for(Node child : n.adjacent){
                if(!child.marked){
                    child.marked = true;
                    stack.push(child);
                }
            }
            visit(n);
        }
    }

    void bfs(){
        bfs(0);
    }

    void bfs(int index){
        Node start = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(start);
        start.marked = true;
        while (!queue.isEmpty()){
            Node n = queue.dequeue();
            for(Node child : n.adjacent){
                if(!child.marked){
                    child.marked = true;
                    queue.enqueue(child);
                }
            }
            visit(n);
        }
    }

    void dfsR(){
        dfsR(0);
    }

    void dfsR(int index){
        Node root = nodes[index];
        dfsR(root);
    }

    void dfsR(Node n){
        if(n == null) return;
        n.marked = true;
        visit(n);
        for(Node r : n.adjacent){
            if(!r.marked){
                dfsR(r);
            }
        }
    }

    void visit(Node n){
        System.out.print(n.data + " ");
    }
}