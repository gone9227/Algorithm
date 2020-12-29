package algorithm.treeGraph;

import java.util.*;

public class BfsDfs {

    private static StringBuilder sb;
    private static int[][] matrix;
    private static boolean[] marked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodesCnt = sc.nextInt();
        int edgesCnt = sc.nextInt();
        int startIdx = sc.nextInt();

        sb = new StringBuilder();

        matrix = new int[nodesCnt + 1][nodesCnt + 1];
        marked = new boolean[nodesCnt + 1];

        for(int i = 0; i < edgesCnt; i++){
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            matrix[i1][i2] = matrix[i2][i1] = 1;
        }

        dfs(startIdx);
        sb.append("\n");
        Arrays.fill(marked, false);
        bfs(startIdx);

        System.out.println(sb.toString());
    }

    private static void dfs(int index){
        if(marked[index]) return;

        marked[index] = true;
        sb.append(index).append(" ");

        for(int j = 1; j <= matrix[index].length - 1; j++){
            if(matrix[index][j] == 1 && !marked[j]){
                dfs(j);
            }
        }
    }

    private static void bfs(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        marked[index] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 1; i <= matrix[node].length - 1; i++){
                if(matrix[node][i] == 1 && !marked[i]){
                    marked[i] = true;
                    queue.add(i);
                }
            }
            sb.append(node).append(" ");
        }
    }
}
