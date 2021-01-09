package algorithm.stackQueue;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10845
 */
public class QueueProblem {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        sc.nextLine();

        Queue q = new Queue();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < total; i++){
            String order = sc.nextLine();
            if(order.contains("push")){
                q.push(Integer.parseInt(order.split(" ")[1]));
            }else if(order.equals("pop")){
                sb.append(q.pop());
                sb.append("\n");
            }else if(order.equals("size")){
                sb.append(q.size());
                sb.append("\n");
            }else if(order.equals("empty")){
                sb.append(q.isEmpty());
                sb.append("\n");
            }else if(order.equals("front")){
                sb.append(q.front());
                sb.append("\n");
            }else if(order.equals("back")){
                sb.append(q.back());
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static class Queue{
        private class Node{
            public int data;
            public Node after;

            public Node(int data){
                this.data = data;
            }
        }

        private Node front;
        private Node back;
        private int size;

        public Queue(){
            this.front = null;
            this.back = null;
            this.size = 0;
        }

        public void push(int i){
            if(front == null){
                front = new Node(i);
                back = front;
            }else{
                Node addNode = new Node(i);
                back.after = addNode;
                back = addNode;
            }
            size++;
        }

        public int pop(){
            if(front == null){
                return -1;
            }
            int pop = front.data;
            front = front.after;
            size--;
            if(size == 0){
                front = null;
                back = null;
            }
            return pop;
        }

        public int size(){
            return this.size;
        }

        public int isEmpty(){
            if(size == 0) return 1;
            else return 0;
        }

        public int front(){
            if(front == null) return -1;
            return front.data;
        }

        public int back(){
            if(back == null) return -1;
            return back.data;
        }

        public void printQ(){
            Node q = front;
            while (q != null){
                System.out.print(q.data + " ");
                q = q.after;
            }
            System.out.println();
        }
    }

}
