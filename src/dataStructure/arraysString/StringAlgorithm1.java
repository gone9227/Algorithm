package dataStructure.arraysString;

/**
 * ASCII로만 이루어진 문자열에서 중복 문자 찾기
 */
public class StringAlgorithm1 {

    public static void main(String[] args) {
        System.out.println(isUnique("abcdefghijklm"));
        System.out.println(isUnique("abcdefghaijklm"));
    }

    private static boolean isUnique(String str){
        if(str.length() > 128){
            return false;
        }

        boolean[] charSet = new boolean[128];

        for (char c : str.toCharArray()) {
            if(charSet[c]){
                return false;
            }
            charSet[c] = true;
        }
        return true;
    }

}
