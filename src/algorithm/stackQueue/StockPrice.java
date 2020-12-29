package algorithm.stackQueue;

import java.util.Arrays;

/**
 * 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */
public class StockPrice {
    public static void main(String[] args){
        int[] result = solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] prices){
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                answer[i]++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }

}
