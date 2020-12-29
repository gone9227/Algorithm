package algorithm;

import java.text.Collator;
import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class PopularAlbum {

    public static void main(String[] args) {
//        genres = [classic, pop, classic, classic, pop]
//        plays = [500, 600, 150, 800, 2500]
//        return = [4, 1, 3, 0]
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        LinkedHashMap<String, Integer> playsPerGenres = new LinkedHashMap<>();
        HashMap<String, ArrayList<Integer>> ranksPerGenres = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(!ranksPerGenres.containsKey(genres[i])){
                ArrayList<Integer> newRanks = new ArrayList<>();
                newRanks.add(i);
                ranksPerGenres.put(genres[i], newRanks);
            }else {
                if(ranksPerGenres.get(genres[i]).get(0) < plays[i]){
                    ranksPerGenres.get(genres[i]).add(0, i);
                }else {
                    ranksPerGenres.get(genres[i]).add(i);
                }
            }
            playsPerGenres.put(genres[i], playsPerGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Integer> rankList = new ArrayList<>();
        for (Map.Entry<String, Integer> playsPerGenre : playsPerGenres.entrySet()) {

        }

        return answer;
    }
}
