package dataStructure.Tree;

public class TreeBalanceCheck {

    public static void main(String[] args){
        Tree t = new Tree(10);

        boolean result = t.isBalanced(t.root);
        System.out.println(result);
        System.out.println(t.isBalanced2(t.root));
        System.out.println(t.isBalanced3(t.root));
    }

    private static class Tree{
        class Node{
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
//            root.right.right.right.right = new Node(10);
//            root.right.right.left = new Node(11);
        }

        public Node makeBTree(int start, int end){
            if(start > end) return null;
            int mid = (start + end) / 2;

            Node node = new Node(mid);
            node.left = makeBTree(start, mid - 1);
            node.right = makeBTree(mid + 1, end);

            return node;
        }

        public boolean isBalanced(Node n){
            if(n == null) return true;
            int heightDiff = getHeight(n.left) - getHeight(n.right);
            if(Math.abs(heightDiff) > 1){
                return false;
            }else {
                return isBalanced(n.left) && isBalanced(n.right);
            }
        }

        public int getHeight(Node n){
            if(n == null) return -1;
            return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
        }

        public boolean isBalanced2(Node n){
            return checkHeight(n) != Integer.MIN_VALUE;
        }

        public int checkHeight(Node n){
            if(n == null) return -1;
            int leftHeight = checkHeight(n.left);
            if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            int rightHeight = checkHeight(n.right);
            if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

            int heightDiff = leftHeight - rightHeight;
            if(Math.abs(heightDiff) > 1){
                return Integer.MIN_VALUE;
            }else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }

        class Level{
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
        }
        public boolean isBalanced3(Node n){
            Level level = new Level();
            checkBalance(n, level, 0);
            if(Math.abs(level.min - level.max) > 1) return false;
            else return true;
        }

        public void checkBalance(Node n, Level obj, int level){
            if(n == null){
                if(level < obj.min) obj.min = level;
                else if(level > obj.max) obj.max = level;
                return;
            }
            checkBalance(n.left, obj, level + 1);
            checkBalance(n.right, obj, level + 1);
        }
    }

}
