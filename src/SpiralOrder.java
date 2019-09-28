import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m == 0){
            return result;
        }
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int totalNum = m * n;
        int i = 0;
        int[] currentDirection = direction[i];
        int curX = 0;
        int curY = 0;
        while(true){
            if(!visited[curX][curY]){
                result.add(matrix[curX][curY]);
                visited[curX][curY] = true;
                if(result.size() == totalNum){
                    break;
                }
            }
            int nexX = curX + currentDirection[0];
            int nexY = curY + currentDirection[1];
            while(!isValidPos(nexX,nexY,m,n) || visited[nexX][nexY]){
                currentDirection = direction[(i++) % 4];
                nexX = curX + currentDirection[0];
                nexY = curY + currentDirection[1];
            }
            curX = nexX;
            curY = nexY;

        }
        return result;
    }

    public boolean isValidPos(int x, int y, int rows, int cols){
        if(x >= 0 && x < rows && y >= 0 && y < cols){
            return true;
        }else{
            return false;
        }
    }
}
