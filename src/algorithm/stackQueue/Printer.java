package algorithm.stackQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Printer {
    public static void main(String[] args){
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        HashMap<Integer, Integer> jobs = new HashMap<Integer, Integer>();
        for(int i = 0; i < priorities.length; i++){
            jobs.put(i, i);
        }

        int diff = 0;
        int i = 0;
        while (i < priorities.length - 1){
            for(int j = i + 1; j < priorities.length; j++){
                if(priorities[i] < priorities[j]){
                    diff = j - i;
                }
            }

            i++;
        }

        for (Map.Entry<Integer, Integer> job : jobs.entrySet()) {
            if(job.getKey() >= diff){
                job.setValue(job.getValue() - diff);
            }else {
                job.setValue(job.getValue() + priorities.length - diff);
            }
        }

        answer = jobs.get(location);
        return answer;
    }

}

/*
*
* 중요한 건 리스트에 순서대로 저장하는게 아니라 "몇번째"로 출력되는지다!
* 그러므로 location 을 하나씩 땡기면서 출력될 순서를 하나씩 늘려주면 따로 저장공간을 많이 쓰지 않고도 할 수 있음...와우..
*
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
    List<Integer> list = new ArrayList<>();
    for (int priority : priorities) {
      list.add(priority);
    }

    int turn = 1;
    while (!list.isEmpty()) {
      final Integer j = list.get(0);
      if (list.stream().anyMatch(v -> j < v)) {
        list.add(list.remove(0));
      } else {
        if (location == 0) {
          return turn;
        }
        list.remove(0);
        turn++;
      }

      if (location > 0) {
        location--;
      } else {
        location = list.size() - 1;
      }
    }

    throw new IllegalArgumentException();
  }
}
*
* */
