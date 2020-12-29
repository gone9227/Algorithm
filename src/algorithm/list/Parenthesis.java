package algorithm.list;

import java.util.ArrayList;
import java.util.Scanner;

public class Parenthesis {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        String s;
        for(int i = 0; i < cnt; i++){
            s = sc.next();
            sb.append(isVps(s) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean isVps(String s){

        ArrayList<Boolean> vpsArr = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(vpsArr.size() == 0){
                    return false;
                }else {
                    vpsArr.remove(vpsArr.size() - 1);
                }
            }else {
                vpsArr.add(true);
            }
        }

        return vpsArr.size() == 0;

    }


}
