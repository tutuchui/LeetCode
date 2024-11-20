package graduate;

import java.util.Scanner;

public class Game2048 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int operation = Integer.valueOf(scanner.nextLine());
        int[][] matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            String tmp = scanner.nextLine();
            matrix[i][0] = Integer.valueOf(tmp.split(" ")[0]);
            matrix[i][1] = Integer.valueOf(tmp.split(" ")[1]);
            matrix[i][2] = Integer.valueOf(tmp.split(" ")[2]);
            matrix[i][3] = Integer.valueOf(tmp.split(" ")[3]);
        }

        switch (operation){
            case 1:
                for(int j = 0; j < 4;j++){
                    for(int i = 0; i < 3;i++){
                        if(matrix[i][j]!=0 && matrix[i][j] == matrix[i+1][j]){
                            matrix[i][j] = 2 * matrix[i][j];
                            matrix[i+1][j] = -1;
                        }
                    }
                    for(int i = 0; i < 3;i++){
                        if(matrix[i][j] == -1){
                            matrix[i][j] = matrix[i+1][j];
                            matrix[i+1][j] = 0;
                        }
                    }
                    for(int i = 0; i < 4;i++){
                        if(matrix[i][j] == -1){
                            matrix[i][j] = 0;
                        }
                    }
                }
                break;
            case 2:
                for(int j = 0; j < 4;j++){
                    for(int i = 3; i > 0;i--){
                        if(matrix[i][j]!=0 && matrix[i][j] == matrix[i-1][j]){
                            matrix[i][j] = 2 * matrix[i][j];
                            matrix[i-1][j] = -1;
                        }
                    }
                    for(int i = 0; i < 3;i++){
                        if(matrix[i][j] == -1){
                            matrix[i][j] = matrix[i-1][j];
                            matrix[i-1][j] = 0;
                        }
                    }
                    for(int i = 0; i < 4;i++){
                        if(matrix[i][j] == -1){
                            matrix[i][j] = 0;
                        }
                    }
                }
                break;
        }
        for(int i = 0; i < 4;i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
     }

}
