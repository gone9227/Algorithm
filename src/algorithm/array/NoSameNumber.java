package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class NoSameNumber {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] arr){
        int[] answer = {};
        List<Integer> ans = new ArrayList<Integer>();

        int last = -1;
        ans.add(arr[0]);
        for(int i : arr){
            last = ans.get(ans.size() - 1);
            if(last != i){
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();

    }
}
