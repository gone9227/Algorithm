package dataStructure.arraysString;

public class StringAlgorithm7 {

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));
    }

    private static boolean isPermutationOfPalindrome(String str){
        int[] table = buildCharFrequencyTable(str);
        return getMaxOneOdd(table);

    }

    private static boolean getMaxOneOdd(int[] table){
        boolean isOdd = false;

        for (int i : table) {
            if(i % 2 == 1){
                if(!isOdd){
                    isOdd = true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] buildCharFrequencyTable(String str){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        boolean isOdd = false;

        for(Character c : str.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }
        return table;
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
