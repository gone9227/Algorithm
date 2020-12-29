package algorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackPrac2 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int orderNum = sc.nextInt();
        String order;
        for (int i = 0; i < orderNum; i++){
            order = sc.next();
            if(order.contains("push")){
                int data = sc.nextInt();
                stack.push(data);
            }else if(order.equals("pop")){
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            }else if(order.equals("size")){
                System.out.println(stack.size());
            }else if(order.equals("empty")){
                System.out.println(stack.isEmpty() ? 1 : 0);
            }else if(order.equals("top")){
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }

}
