package algorithm.greedy;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/11047
 */
public class CoinCounts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int kindCnt = sc.nextInt();
        int total = sc.nextInt();

        Stack<Integer> purse = new Stack<Integer>();
        for(int i = 0; i < kindCnt; i++){
            int val = sc.nextInt();
            if(val <= total){
                purse.add(val);
            }
        }

        int coinCnt = 0;
        while (!purse.isEmpty()){
            int val = purse.pop();
            coinCnt += total / val;
            total %= val;
            if(total <= 0){
                break;
            }
        }

        System.out.println(coinCnt);

    }

}
