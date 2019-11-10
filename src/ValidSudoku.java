//Leetcode 36
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        char[] testCharArray = new char[9];
        //Validate row
        for(int i = 0; i < board.length; i++){
            testCharArray = board[i];
            if(!isValidArray(testCharArray)){
                System.out.println("row");
                return false;
            }
        }
        //Validate col
        for(int j = 0; j < board.length; j++){
            testCharArray = new char[9];
            for(int i = 0; i < board.length; i++){
                testCharArray[i] = board[i][j];
            }
            if(!isValidArray(testCharArray)){
                System.out.println("col");
                return false;
            }
        }
        for(int k = 0; k < 9; k++){
            testCharArray = new char[9];
            int l = 0;
            int cur_r = (k / 3) * 3;
            int cur_c = (k % 3) * 3;
            for(int i = cur_r; i < cur_r + 3; i++){
                for(int j = cur_c; j < cur_c + 3; j++){
                    testCharArray[l] = board[i][j];
                    l++;
                }
            }
            if(!isValidArray(testCharArray)){
                System.out.println("block");
                return false;
            }
        }
        return true;

    }

    public boolean isValidArray(char[] testArray) {
        boolean[] isVisited = new boolean[9];
        for (char cur : testArray) {
            if (cur == '.') {
                continue;
            }
            if (isVisited[Character.getNumericValue(cur) - 1]) {
                return false;
            } else {
                isVisited[Character.getNumericValue(cur) - 1] = true;
            }
        }
        return true;
    }
}
