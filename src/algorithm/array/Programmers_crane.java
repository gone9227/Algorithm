package algorithm.array;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class Programmers_crane {
    public static void main(String[] args) {
        // write your code here
        int[][] board = {{0,0,0,0,0}
                        ,{0,0,1,0,3}
                        ,{0,2,5,0,1}
                        ,{4,2,4,4,2}
                        ,{3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};
        int solution = solution(board, moves);
        //4

        System.out.println(solution);
    }

    public static int solution(int[][] board, int[] moves){

        int answer = 0;
        int[] basket = new int[1000];
        int idx = 0;

        for(int i : moves){
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i] - 1] != 0) {
                    if (idx != 0 && basket[idx - 1] == board[j][moves[i] - 1]) {
                        basket[idx - 1] = 0;
                        idx--;
                        answer += 2;
                    } else {
                        basket[idx] = board[j][moves[i] - 1];
                        idx++;
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
