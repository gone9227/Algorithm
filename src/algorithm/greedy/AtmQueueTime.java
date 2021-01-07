package algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11399
 */
public class AtmQueueTime {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int min = 0;
        for(int i : arr){
            min += i * len;
            len--;
        }

    }

}
