package dataStructure.arraysString;

import java.util.HashMap;

/**
 * 유니코드 문자열일 경우 중복 체크
 */
public class StringAlgorithm2 {

    public static void main(String[] args) {
        System.out.println(isUnique("abcdefghijklm"));
        System.out.println(isUnique("abcdefghaijklm"));
    }

    private static boolean isUnique(String str){
        HashMap<Integer, Boolean> strMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            int c = str.charAt(i);
            if(strMap.containsKey(c)){
                return false;
            }
            strMap.put(c, true);
        }
        return true;
    }

}
