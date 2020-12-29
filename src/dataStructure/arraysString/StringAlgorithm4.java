package dataStructure.arraysString;

import java.util.Arrays;

/**
 * 문자열 치환 가능 여부 - 공백, 대소문자 구분 O
 */
public class StringAlgorithm4 {

    public static void main(String[] args) {
        System.out.println(permutation("ABC", "CBA"));
        System.out.println(permutation("ABC", "CDA"));
    }

    private static String sort(String str){
        char[] strData = str.toCharArray();
        Arrays.sort(strData);
        return new String(strData);
    }

    private static boolean permutation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

}
