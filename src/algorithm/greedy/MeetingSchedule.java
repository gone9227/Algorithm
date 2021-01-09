package algorithm.greedy;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class MeetingSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int meetings = sc.nextInt();
        ArrayList<int[]> sets = new ArrayList<>();

        for(int i = 0; i < meetings; i++){
            int[] set = new int[2];
            set[0] = sc.nextInt();
            set[1] = sc.nextInt();
            sets.add(set);
        }

        ArrayList<Integer> cnts = new ArrayList<>();
        int meetingCnt = 0;


        while (true){

        }


    }

}
