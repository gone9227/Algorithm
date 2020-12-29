package dataStructure.arraysString;

/**
 * 0의 행과 열을 모두 0으로 변환하는 알고리즘
 */
public class MatrixAlgorithm2 {

    public static void main(String[] args) {
        int[][] newMatrix = {
                {1, 1, 1, 1}
                , {1, 0, 1, 1}
                , {1, 1, 1, 0}
                , {1, 0, 1, 1}};
        printImage(newMatrix);
        setZeroToAllZero(newMatrix);
        printImage(newMatrix);
    }

    private static void setZeroToAllZero(int[][] matrix){

        int fc = -1;
        int fr = -1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    if(fc == -1){
                        fr = i;
                        fc = j;
                    }
                    matrix[i][fc] = 0;
                    matrix[fr][j] = 0;
                }
            }
        }
        if(fc == -1) return;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[fr][i] == 0 && i != fc){
                setColsToZero(i, matrix);
            }
        }

        for(int j = 0; j < matrix.length; j++){
            if(matrix[j][fr] == 0){
                setRowsToZero(j, matrix);
            }
        }

        setColsToZero(fc, matrix);

    }

    private static void setRowsToZero(int row, int[][] matrix) {
        for(int j = 0; j < matrix[row].length; j++){
            matrix[row][j] = 0;
        }
    }

    private static void setColsToZero(int col, int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    private static void printImage(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
