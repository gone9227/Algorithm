package dataStructure.graph;

import java.util.LinkedList;

public class BwnTwoNodes {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
//        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        boolean search = g.search(1, 8);
        System.out.println(search);
    }

    private static class Graph{
        public class Node{
            int data;
            boolean marked;
            LinkedList<Node> adjacent;
            public Node(int data){
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
            }
        }

        Node[] nodes;
        public Graph(int size){
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

        public boolean search(int i1, int i2){
            return search(nodes[i1], nodes[i2]);
        }

        private boolean search(Node n1, Node n2){
            LinkedList<Node> q = new LinkedList<>();
            q.add(n1);
            while (!q.isEmpty()){
                Node root = q.removeFirst();
                if(root == n2){
                    return true;
                }

                for(Node child : root.adjacent){
                    if(!child.marked){
                        child.marked = true;
                        q.add(child);
                    }
                }
            }
            return false;
        }
    }


}

