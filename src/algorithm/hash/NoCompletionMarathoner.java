package algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoCompletionMarathoner {
    public static void main(String[] args) {
        Solution sl = new Solution();

//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String result = sl.solution2(participant, completion);
        System.out.println(result);

    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Map<String, Integer> completeMap = new HashMap<>();

            for (String name : completion) {
                if (completeMap.containsKey(name)) {
                    completeMap.put(name, completeMap.get(name) + 1);
                }else {
                    completeMap.put(name, 1);
                }
            }

            for (String name : participant) {
                if(!completeMap.containsKey(name)){
                    answer = name;
                    break;
                }

                if(completeMap.get(name) == 0){
                    answer = name;
                    break;
                }else {
                    completeMap.replace(name, completeMap.get(name) - 1);
                }
            }

            return answer;
        }

        public String solution2(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);
            System.out.println("Participant = " + Arrays.toString(participant));
            System.out.println("Completion = " + Arrays.toString(completion));

            for(int i = 0; i < completion.length; i++){
                if(!participant[i].equals(completion[i])){
                    return participant[i];
                }
            }
            answer = participant[participant.length - 1];
            return answer;
        }
    }

}
