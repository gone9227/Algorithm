package dataStructure.arraysString;

/**
 * 문자열 압축하기
 */
public class StringAlgorithm11 {

    public static void main(String[] args) {

        System.out.println(compressString("aaaaaabbcccdddd"));
        System.out.println(compressString("abcd"));

    }

    private static String compressString(String str){

        String newStr = compress(str);
        return str.length() < newStr.length() ? str : newStr;

    }

    private static String compress(String str){
        java.lang.StringBuilder newStr = new java.lang.StringBuilder(getTotalCount(str));

        int count = 0;
        for(int i = 0; i < str.length(); i++){
            count++;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                newStr.append(str.charAt(i));
                newStr.append(count);
                count = 0;
            }
        }

        return newStr.toString();
    }

    private static int getTotalCount(String str) {

        int count = 0;
        int totalCnt = 0;

        for(int i = 0; i < str.length(); i++){
            count++;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                totalCnt++;
                totalCnt += String.valueOf(count).length();
                count = 0;
            }
        }
        return totalCnt;
    }

}
