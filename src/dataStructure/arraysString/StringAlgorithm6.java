package dataStructure.arraysString;

/**
 * 문자열 공백 엔코딩 하는 알고리즘
 */
public class StringAlgorithm6 {

    public static void main(String[] args) {

        System.out.println(URLify("Mr John Smith    ", 13));

    }

    private static String URLify(String str, int len){
        return URLify(str.toCharArray(), len);
    }

    private static String URLify(char[] strData, int len){

        int space = 0;
        for(int i = 0; i < len; i++){
            if(strData[i] == ' '){
                space++;
            }
        }

        int index = len + (space * 2) - 1;
        for(int p = len - 1; p >= 0; p--){
            if(strData[p] == ' '){
                strData[index--] = '0';
                strData[index--] = '2';
                strData[index--] = '%';
            }else {
                strData[index--] = strData[p];
            }
        }

        return new String(strData);
    }

}
