package dataStructure.arraysString;

public class StringAlgorithm9 {

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));
    }

    private static boolean isPermutationOfPalindrome(String str){
        int bitVector = createBitVector(str);
        return bitVector == 0 || checkExactlyOneBitVector(bitVector);
    }

    private static int createBitVector(String str){
        int bitVector = 0;
        for (char c : str.toCharArray()) {
            int charNumber = getCharNumber(c);
            bitVector = toggle(bitVector, charNumber);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int charNumber) {
        if(charNumber < 0) return bitVector;
        int mask = 1  << charNumber;
        if((bitVector & mask) == 0){
            bitVector |= mask;
        }else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private static boolean checkExactlyOneBitVector(int bitVector){
        return (bitVector & (bitVector - 1)) == 0;
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
