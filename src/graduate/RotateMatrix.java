package graduate;

//Leetcode 48
public class RotateMatrix {
    public void rotate(int[][] matrix){

        int n = matrix.length;
        if(n == 0){
            return;
        }
        //Transpose the matrix first
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //Reverse each row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
