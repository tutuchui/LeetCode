package graduate;

import java.util.LinkedList;
import java.util.Scanner;

public class NumOfDouyou {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        int[][] douYou = new int[N][N];
        for(int i = 0; i < N;i++){
            String tmpLine = scanner.nextLine();
            for(int j = 0; j < N; j++){
                douYou[i][j] = Integer.valueOf(tmpLine.split(" ")[j]);
            }
        }
        NumOfDouyou main = new NumOfDouyou();
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];
        boolean[] isVisitedLine = new boolean[N];
        for(int i = 0; i < douYou.length;i++) {
            if (!isVisitedLine[i]) {
                if (!main.isHasFriend(douYou, i)) {
                    count++;
                    continue;
                }
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    int cur = queue.removeFirst();
                    isVisitedLine[cur] = true;
                    for (int j = 0; j < douYou[cur].length; j++) {
                        if (!isVisited[cur][j] && douYou[cur][j] > 3) {
                            queue.addLast(j);
                            isVisited[cur][j] = true;
                            isVisited[j][cur] = true;
                        }
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }



    public boolean isHasFriend(int[][] friend, int i){
        for(int j = 0; j < friend[i].length;j++){
            if(friend[i][j] > 3){
                return true;
            }
        }
        return false;
    }


}
