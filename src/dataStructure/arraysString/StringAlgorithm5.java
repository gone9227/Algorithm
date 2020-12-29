package dataStructure.arraysString;

import java.util.Arrays;

/**
 * 문자열 치환 가능 여부 - 공백, 대소문자 구분 O
 */
public class StringAlgorithm5 {

    public static void main(String[] args) {
        System.out.println(permutation("ABC", "CBA"));
        System.out.println(permutation("ABC", "CDA"));
    }

    private static boolean permutation(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        int[] data = new int[128];
        for(int i = 0; i < str1.length(); i++){
            data[str1.charAt(i)]++;
        }
        for(int i = 0; i < str2.length(); i++){
            data[str2.charAt(i)]--;
            if(data[str2.charAt(i)] < 0) return false;
        }
        return true;
    }

}
