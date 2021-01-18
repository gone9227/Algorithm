package algorithm.leetCode;

import java.util.Stack;

public class ReversedInteger {
    public static void main(String[] args) {
        int x = -123;

        int reversed = getReversed2(x);
        System.out.println(reversed);
    }

    private static int getReversed2(int x) {
        long reversed = 0;

        while (x != 0){
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE ? 0 : (int)reversed;
    }

    private static int getReversed(int x) {
        String s = String.valueOf(x);
        String reversed = "";
        char[] c;
        if(s.contains("-")){
            reversed = reversed.concat("-");
            c = s.substring(1).toCharArray();
        }else {
            c = s.toCharArray();
        }

        for(int i = c.length - 1; i >= 0; i--){
            reversed = reversed.concat(String.valueOf(c[i]));
        }

        try{
            return Integer.parseInt(reversed);
        }catch (NumberFormatException ne){
            return 0;
        }
    }
}


/**
 * 정말 수학적 사고를 잘하고 싶다....
 *
 * class Solution {
 *     public int reverse(int x) {
 *        long reverseNum = 0;
 *         // reverse the num
 *         while(x!=0){
 *             reverseNum= reverseNum*10+x%10;
 *             x/=10;
 *         }
 *
 *         if(reverseNum>Integer.MAX_VALUE||reverseNum<Integer.MIN_VALUE)
 *             return 0;
 *         return (int)reverseNum;
 *     }
 * }
 *
 */