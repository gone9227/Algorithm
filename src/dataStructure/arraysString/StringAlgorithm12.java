package dataStructure.arraysString;

/**
 * isSubstring() 함수 한번만 호출해서 문자열 회전여부 알아내기
 */
public class StringAlgorithm12 {

    public static void main(String[] args) {
        System.out.println(isRotation("string", "ingstr"));
        System.out.println(isRotation("string", "ngstri"));
        System.out.println(isRotation("string", "ngstre"));
        System.out.println(isRotation("string", "ingstri"));
    }

    private static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        return isSubstring(s1 + s1, s2);
    }

    private static boolean isSubstring(String s, String s2) {
        return s.contains(s2);
    }

}
