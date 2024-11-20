package graduate;

import java.util.LinkedList;

public class NumIsLand {

    public int numIslands_BFS(char[][] grid) {

        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }

        int cols = grid[0].length;
        int numLand = 0;
        boolean[][] marked = new boolean[rows][cols];

        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(!marked[i][j] && grid[i][j] == '1'){
                    numLand++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    marked[i][j] = true;
                    queue.addLast(i * cols + j);
                    while(!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int cur_i = cur / cols;
                        int cur_j = cur % cols;
                        for (int k = 0; k < 4; k++) {
                            int new_i = cur_i + direction[k][0];
                            int new_j = cur_j + direction[k][1];
                            if (inArea(new_i, new_j, rows, cols) && grid[new_i][new_j] == '1' && !marked[new_i][new_j]) {
                                marked[new_i][new_j] = true;
                                queue.addLast(new_i * cols + new_j);
                            }
                        }
                    }
                }
            }
        }
        return numLand;

    }

    public boolean inArea(int i,int j,int rows,int cols){

        if(i >= 0 && i < rows && j >= 0 && j < cols){
            return true;
        }
        return false;
    }

    public void dfs(int i, int j,int row, int col, boolean[][] isVisited,char[][]grid){
        isVisited[i][j] = true;
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0; k < 4;k++){
            int new_i = i + direction[k][0];
            int new_j = j + direction[k][1];
            if(inArea(new_i,new_j,row,col) && !isVisited[new_i][new_j] && grid[new_i][new_j] == '1'){
                dfs(new_i,new_j,row,col,isVisited,grid);
            }
        }
    }

    public int numIsLand_DFS(char[][] grid){
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int num = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!isVisited[i][j] && grid[i][j] == '1'){
                    num += 1;
                    dfs(i,j,row,col,isVisited,grid);
                }
            }
        }
        return num;
    }

}
