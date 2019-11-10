import java.util.HashSet;

//Leetcode 73
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> zeroRow = new HashSet<>();
        HashSet<Integer> zeroCol = new HashSet<>();
        if(matrix.length == 0){
            return;
        }
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }

        for(int r : zeroRow){
            for(int j = 0; j < matrix[r].length;j++){
                matrix[r][j] = 0;
            }
        }

        for(int c : zeroCol){
            for(int i = 0; i < matrix.length;i++){
                matrix[i][c] = 0;
            }
        }
    }
}
