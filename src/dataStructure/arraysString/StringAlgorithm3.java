package dataStructure.arraysString;

/**
 * 소문자로만 이루어진 문자 저장 공간 없이 중복 검색(비트연산)
 */
public class StringAlgorithm3 {

    public static void main(String[] args) {
        System.out.println(isUnique("abcdefghijklm"));
        System.out.println(isUnique("abcdefghaijklm"));
    }

    private static boolean isUnique(String str){
        int checker = 0;

        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

}
