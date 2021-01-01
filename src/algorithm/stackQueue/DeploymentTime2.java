package algorithm.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * Array 지식을 쌓은 후 코드 정리
 */
public class DeploymentTime2 {

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        int[] progresses = {99, 1, 99, 1};
        int[] speeds = {1, 1, 1, 1};
        int[] result = solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        LinkedList<Job> jobs = new LinkedList<Job>();
        Job job;
        for(int i = 0; i < progresses.length; i++){
            job = new Job(progresses[i], speeds[i]);
            jobs.add(job);
        }

        Job first = jobs.poll();
        if(first == null) return answer;

        int days = getWorkingDays(first.progress, first.speed);
        int cnt = 0;
        answer[cnt]++;

        while (!jobs.isEmpty()){
            Job next = jobs.poll();
            if (getWorkingDays(next.progress, next.speed) > days) {
                days = getWorkingDays(next.progress, next.speed);
                cnt++;
            }
            answer[cnt]++;
        }

        return Arrays.stream(answer).filter(i -> i != 0).toArray();
    }

    private static int getWorkingDays(int progress, int speed){
        int days = (100 - progress) / speed;
        if((100 - progress) % speed != 0){
            days++;
        }
        return days;
    }

    static class Job{
        int progress;
        int speed;
        public Job(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
}
