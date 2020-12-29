package algorithm.list;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class Programmers_addTwoNums {

    public static void main(String[] args) {
        Solution sl = new Solution();
//        int[] result = sl.solution(new int[]{2, 1, 3, 4, 1});
        int[] result2 = sl.solution(new int[]{5,0,2,7});
//        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

}

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        List<Integer> plusNums = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                Integer vlu = numbers[i] + numbers[j];
                if(!plusNums.contains(vlu)){
                    plusNums.add(vlu);
                }
            }
        }

        int[] tmp = new int[plusNums.size()];

        plusNums.sort(Comparator.naturalOrder());
        for(int i = 0; i < plusNums.size(); i++){
            tmp[i] = plusNums.get(i);
        }

        answer = tmp;
        return answer;
    }
}
