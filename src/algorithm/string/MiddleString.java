package algorithm.string;

public class MiddleString {
    public static void main(String[] args) {
        String result = solution2("qwer");
        System.out.println(result);
    }

    public static String solution(String s){
        String answer = "";
        int q = s.length() / 2;
        int r = s.length() % 2;
        if(r != 0){
            answer = s.substring(q + r - 1, q + r);
        }else{
            answer = s.substring(q - 1, q + 1);
        }
        return answer;
    }

    public static String solution2(String s){
        String answer = "";
        answer = s.substring((s.length() - 1) / 2, s.length() / 2 + 1);
        return answer;
    }
}
