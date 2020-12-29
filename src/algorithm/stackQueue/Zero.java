package algorithm.stackQueue;

import java.util.*;

public class Zero {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int cnt = sc.nextInt();
//        java.util.Stack<Integer> nums = new java.util.Stack<>();
//
//        int num;
//        int total = 0;
//        for(int i = 0; i < cnt; i++){
//            num = sc.nextInt();
//            if(num == 0){
//                nums.pop();
//            }else {
//                nums.push(num);
//            }
//        }
//
//        while (!nums.isEmpty()){
//            total += nums.pop();
//        }
//
//        System.out.println(total);
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        java.util.Stack<Integer> nums = new java.util.Stack<>();

        int num;
        int total = 0;
        for(int i = 0; i < cnt; i++){
            num = sc.nextInt();
            if(num == 0){
                total -= nums.pop();
            }else {
                nums.push(num);
                total += num;
            }
        }
        System.out.println(total);
    }
}
