package dataStructure.arraysString;

/**
 * 문자 편집을 단 한번만(또는 안 한) 했는지 여부 판단 함수
 */
public class StringAlgorithm10 {

    public static void main(String[] args) {
        System.out.println(isOneWay("pal", "pale"));
        System.out.println(isOneWay("pale", "ple"));
        System.out.println(isOneWay("pale", "bale"));
        System.out.println(isOneWay("pale", "bal"));
    }

    private static boolean isOneWay(String s1, String s2){
        String shortS, longS;
        if(s1.length() < s2.length()){
            shortS = s1;
            longS = s2;
        }else {
            shortS = s2;
            longS = s1;
        }

        if(longS.length() - shortS.length() > 1) return false;

        boolean flag = false;

        for(int i = 0, j = 0; i < shortS.length(); i++, j++){
             if(shortS.charAt(i) != longS.charAt(j)){
                if(flag){
                    return false;
                }
                flag = true;

            }
        }
        return true;
    }

}
