package classisc;

public class IslandCount {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int nums = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    nums++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return nums;
    }

    public boolean inArea(int i, int j, int rows, int cols) {
        if(i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        return true;
    }

    public void dfs(char[][] grid, int i, int j, int row, int col) {
        if(!inArea(i, j, row, col) || grid[i][j] != '1') {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
        }
        dfs(grid, i, j+1, row, col);
        dfs(grid, i, j-1, row, col);
        dfs(grid, i+1, j, row, col);
        dfs(grid, i-1, j, row, col);
    }
}
