package algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class ThiefClothes {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(clothes);
        System.out.println(result);
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, ArrayList<String>> closet = new HashMap<>();

        for (String[] c : clothes) {
            if(!closet.containsKey(c[1])){
                ArrayList<String> clothesName = new ArrayList<>();
                clothesName.add(c[0]);
                closet.put(c[1], clothesName);
            }else {
                closet.put(c[1], closet.get(c[1])).add(c[0]);
            }
        }

        int allValues = 1;
        for (Map.Entry<String, ArrayList<String>> allClothes : closet.entrySet()) {
            int cases = allClothes.getValue().size() + 1;
            allValues = allValues * cases;
        }
        allValues -= 1;
        answer = allValues;
        return answer;
    }

}

/*

String 문법 배우자;;

import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
 */