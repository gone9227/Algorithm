package algorithm.stackQueue;

import java.util.Scanner;

public class StackPrac {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int orderNum = sc.nextInt();
        String order;
        for (int i = 0; i < orderNum; i++){
            order = sc.next();
            if(order.contains("push")){
                int data = sc.nextInt();
                stack.push(data);
            }else if(order.equals("pop")){
                sb.append(stack.pop()).append("\n");
            }else if(order.equals("size")){
                sb.append(stack.size()).append("\n");
            }else if(order.equals("empty")){
                sb.append(stack.isEmpty()).append("\n");
            }else if(order.equals("top")){
                sb.append(stack.top()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}

class Stack<Integer>{
    class Node<Integer>{
        private int data;
        private Node<Integer> next;
        public Node(int data){
            this.data = data;
        }
    }

    private Node<Integer> top;
    private int size;

    public Stack(){
        size = 0;
        top = null;
    }

    public void push(int data){
        Node<Integer> n = new Node<>(data);
        n.next = top;
        top = n;
        size++;
    }

    public int pop(){
        if(size() == 0) return -1;
        int popData = top.data;
        top = top.next;
        size--;
        return popData;
    }

    public int size(){
        return size;
    }

    public int isEmpty(){
        return size == 0 ? 1 : 0;
    }

    public int top(){
        if(size() == 0) return -1;

        return top.data;
    }


}
