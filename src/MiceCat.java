import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MiceCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> mapList = new ArrayList<>();
        String tmp;
        while(!(tmp = scanner.nextLine()).equals("") ){
            mapList.add(tmp);
        }
        int m = mapList.size();
        int n = mapList.get(0).split(" ").length;
        int[][] map = new int[m][n];
        int start_i = -1;
        int start_j = -1;
        boolean[][] isVisited = new boolean[m][n];
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                map[i][j] = Integer.valueOf(mapList.get(i).split(" ")[j]);
                if(map[i][j] == 2){
                    start_i = i;
                    start_j = j;
                }
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        int step = 0;
        queue.add(getIndex(start_i,start_j,n));
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            int cur_i = cur / n;
            int cur_j = cur % n;
            for (int k = 0; k < 4; k++) {
                int new_i = cur_i + direction[k][0];
                int new_j = cur_j + direction[k][1];
                if (inArea(new_i, new_j, m, n) && (map[new_i][new_j] == 0 || map[new_i][new_j] == 3)&& !isVisited[new_i][new_j] ) {
                    isVisited[new_i][new_j] = true;
                    if(map[new_i][new_j] == 3){
                        System.out.println(step + 1);
                        return;
                    }
                    queue2.addLast(new_i * n + new_j);
                }
            }
            if(queue.isEmpty()){
                step += 1;
                queue = queue2;
                queue2 = new LinkedList<>();
            }
        }

    }

    public static boolean inArea(int i,int j,int rows,int cols){

        if(i >= 0 && i < rows && j >= 0 && j < cols){
            return true;
        }
        return false;
    }

    public static int getIndex(int i, int j, int cols){
        return j + i * cols;
    }

}
