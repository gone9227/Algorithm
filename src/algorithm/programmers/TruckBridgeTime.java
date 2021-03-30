package algorithm.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 프로그래머스
 * 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class TruckBridgeTime {
    public static void main(String[] args) {
//        int bridgeLength = 2;
//        int weight = 10;
//        int[] truckWeights = {7, 4, 5, 6};
//        int bridgeLength = 100;
//        int weight = 100;
//        int[] truckWeights = {10};
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};
        int result = solution(bridgeLength, weight, truckWeights);
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int curWeight = 0;

        Queue<Integer> truckQueue = new LinkedList<>();
        List<Integer> onBridgeTime = new ArrayList<>();
        List<Integer> onBridgeWeight = new ArrayList<>();

        for (int truck : truck_weights) {
            truckQueue.add(truck);
        }

        while (!truckQueue.isEmpty() || !onBridgeTime.isEmpty()){
            time++;
            if(!truckQueue.isEmpty()){
                if(curWeight + truckQueue.peek() <= weight){
                    Integer truckOnBridge = truckQueue.poll();
                    onBridgeWeight.add(truckOnBridge);
                    onBridgeTime.add(0);
                    curWeight += truckOnBridge;
                }
            }
            if(!onBridgeTime.isEmpty()){
                onBridgeTime = onBridgeTime
                                .stream()
                                .map(x -> x + 1)
                                .collect(Collectors.toList());

                if(onBridgeTime.get(0) > bridge_length){
                    onBridgeTime.remove(0);
                    curWeight -= onBridgeWeight.get(0);
                    onBridgeWeight.remove(0);
                }
            }
        }

        return time;
    }
}
