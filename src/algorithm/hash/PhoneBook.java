package algorithm.hash;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneBook {

    // [119, 97674223, 1195524421] false
    public static void main(String[] args) {
        boolean solution = solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(solution);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++){
            for(int j = i + 1; j < phone_book.length; j++){
                if(phone_book[i].equals(phone_book[j])){
                    return false;
                }
                if(phone_book[i].length() < phone_book[j].length()){
                    if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])){
                        return false;
                    }
                }else {
                    if(phone_book[i].substring(0, phone_book[j].length()).equals(phone_book[j])){
                        return false;
                    }
                }
            }
        }
        return answer;
    }
}
