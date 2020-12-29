package dataStructure.arraysString;

public class StringAlgorithm8 {

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));
    }

    private static boolean isPermutationOfPalindrome(String str){
        return buildCharFrequencyTable(str);

    }

    private static boolean buildCharFrequencyTable(String str){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        int countOdd = 0;

        for(Character c : str.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                }else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static int getCharNumber(Character c){

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int i = Character.getNumericValue(c);

        if(i >= a && i <= z){
            return i - a;
        }
        return -1;
    }

}
