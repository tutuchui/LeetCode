package dp;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;

        int[][] minSum = new int[m][n];
        int result = 0;
        for(int i = 0; i < n; i++){
            result += grid[0][i];
            minSum[0][i] = result;
        }
        result = 0;
        for(int i = 0; i < m; i++){
            result += grid[i][0];
            minSum[i][0] = result;
        }

        for(int i = 1; i < m;i++){
            for(int j = 1; j < n; j++){
                minSum[i][j] = Math.min(minSum[i][j-1]+grid[i][j],minSum[i-1][j] + grid[i][j]);
            }
        }
        return minSum[m-1][n-1];
    }
}
