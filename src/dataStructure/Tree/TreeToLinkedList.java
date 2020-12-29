package dataStructure.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeToLinkedList {
    public static void main(String[] args){
        Tree t = new Tree(10);
//        ArrayList<LinkedList<Tree.Node>> arr = t.makeTreeList();
        ArrayList<LinkedList<Tree.Node>> arr = t.makeTreeList2();
        t.printList(arr);
    }

    private static class Tree{
        public class Node{
            int data;
            Node left;
            Node right;
            public Node(int data){
                this.data = data;
            }
        }

        Node root;
        public Tree(int size){
            root = makeBTree(0, size - 1);
        }

        private Node makeBTree(int start, int end){
            if(start > end) return null;

            int mid = (start + end) / 2;
            Node node = new Node(mid);
            node.left = makeBTree(start, mid - 1);
            node.right = makeBTree(mid + 1, end);
            return node;
        }

        private ArrayList<LinkedList<Node>> makeTreeList(){
            ArrayList<LinkedList<Node>> list = new ArrayList<>();

            makeList(root, list, 0);

            return list;
        }

        private void makeList(Node root, ArrayList<LinkedList<Node>> list, int level){
            if(root == null) return;

            LinkedList<Node> levList = null;
            if(list.size() == level){
                levList = new LinkedList<>();
                list.add(levList);
            }else {
                levList = list.get(level);
            }
            levList.add(root);
            makeList(root.left, list, level + 1);
            makeList(root.right, list, level + 1);
        }

        private ArrayList<LinkedList<Node>> makeTreeList2(){
            ArrayList<LinkedList<Node>> list = new ArrayList<>();
            LinkedList<Node> q = new LinkedList<>();

            if(root != null){
                q.add(root);
            }

            while (q.size() > 0){
                list.add(q);
                LinkedList<Node> parents = q;
                q = new LinkedList<Node>();
                for(Node parent : parents){
                    if(parent.left != null) q.add(parent.left);
                    if(parent.right != null) q.add(parent.right);
                }
            }

            return list;
        }

        private void printList(ArrayList<LinkedList<Node>> arr){
            for (LinkedList<Node> nodes : arr) {
                for (Node n : nodes) {
                    System.out.print(n.data + " ");
                }
                System.out.println();
            }
        }

    }
}
