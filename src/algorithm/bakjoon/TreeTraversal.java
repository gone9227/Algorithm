package algorithm.bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon - 1991
 * Tree traversal
 */
public class TreeTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for(int i = 0; i < nodeCnt; i++){
            String nodes = br.readLine().replaceAll(" ", "");
            tree.add(nodes.charAt(0), nodes.charAt(1), nodes.charAt(2));
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);

    }



}

class Tree{
    Node root;

    public void add(char data, char left, char right){
        if(root == null){
            if(data != '.') root = new Node(data);
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        }else {
            search(root, data, left, right);
        }
    }
    private void search(Node root, char data, char left, char right){
        if(root == null) return;
        else if(root.value == data){
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        }else {
            search(root.left, data, left, right);
            search(root.right, data, left, right);
        }
    }

    public void preorder(Node root){
        System.out.print(root.value);
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }

    public void inorder(Node root){
        if(root.left != null) inorder(root.left);
        System.out.print(root.value);
        if(root.right != null) inorder(root.right);
    }

    public void postorder(Node root){
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        System.out.print(root.value);
    }

}

class Node{
    char value;
    Node left;
    Node right;

    public Node(char value){
        this.value = value;
    }

}
