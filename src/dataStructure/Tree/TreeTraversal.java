package dataStructure.Tree;

public class TreeTraversal {
    public static void main(String[] args) {
        Tree t = new Tree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n3 = t.makeNode(null, 3, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n1 = t.makeNode(n2 ,1, n3);
        t.setRoot(n1);
//        t.inorder(t.getRoot());
//        t.preorder(t.getRoot());
        t.postorder(t.getRoot());


    }

}

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}

class Tree{
    Node root;

    public void setRoot(Node root){
        this.root = root;
    }
    public Node getRoot(){
        return root;
    }
    public Node makeNode(Node left, int data, Node right){
        Node root = new Node(data);
        root.left = left;
        root.right = right;
        return root;
    }

    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public void preorder(Node node){
        if(node != null){
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

}