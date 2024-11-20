package graduate;

import java.util.ArrayDeque;
import java.util.Queue;

public class AroundArea {

    public void solve(char[][] board) {
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        int rows = board.length;
        if(rows == 0){
            return;
        }
        int cols = board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        for(int i = 1; i < rows - 1; i++){
            for(int j = 1;j < cols - 1; j++){
                if(board[i][j] == 'O' && !isVisited[i][j]){
                    int index = j + cols * i;
                    queue.offer(index);
                    queue2.offer(index);
                    while(!queue.isEmpty()){
                        int cur = queue.poll();
                        int cur_i = cur / cols;
                        int cur_j = cur % cols;
                        isVisited[cur_i][cur_j] = true;
                        for(int k = 0; k < 4; k++){
                            int new_i = cur_i + direction[k][0];
                            int new_j = cur_j + direction[k][1];
                            if(board[new_i][new_j] == 'O' && inArea(new_i,new_j,rows,cols)&&!isVisited[new_i][new_j]){
                                if(!isOnBorder(new_i, new_j, rows, cols)){
                                    int new_index = new_j + new_i * cols;
                                    queue.offer(new_index);
                                    queue2.offer(new_index);
                                }else{
                                    queue.clear();
                                    queue2.clear();
                                }
                                isVisited[new_i][new_j] = true;
                            }
                        }
                        if(queue.isEmpty()){
                            for(int tmp : queue2){
                                int rep_i = tmp / cols;
                                int rep_j = tmp % cols;
                                board[rep_i][rep_j] = 'X';
                            }
                            queue2.clear();
                        }
                    }
                }
            }
        }
    }


    public boolean inArea(int i,int j,int rows,int cols){

        if(i >= 0 && i < rows && j >= 0 && j < cols){
            return true;
        }
        return false;
    }

    public boolean isOnBorder(int i, int j, int rows, int cols){
        if(i == 0 || i == rows - 1 || j == 0 || j == cols -1){
            return true;
        }else{
            return false;
        }
    }

}
