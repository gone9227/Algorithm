package algorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class StackPrac3 {

    public static void main(String[] args) {
        int size = -1;
        int[] arr;

        Scanner sc = new Scanner(System.in);
        arr = new int[sc.nextInt()];

        String order;
        for (int i = 0; i < arr.length; i++){
            order = sc.next();
            if(order.contains("push")){
                int data = sc.nextInt();
                size++;
                arr[size] = data;
            }else if(order.equals("pop")){
                if(size == -1) {
                    System.out.println(-1);
                }else {
                    int popData = arr[size];
                    arr[size] = 0;
                    size--;
                    System.out.println(popData);
                }
            }else if(order.equals("size")){
                System.out.println(size + 1);
            }else if(order.equals("empty")){
                System.out.println(size == -1 ? 1 : 0);
            }else if(order.equals("top")){
                System.out.println(size == -1 ? -1 : arr[size]);
            }
        }
    }

}
