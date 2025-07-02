package classisc;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //Check horizontal line
        for(int i = 0; i < board.length; i++) {
            if(!isValidLine(board[i])) {
                return false;
            }
        }
        //Check Vertical line
        if(!isValidVerticalLine(board)){
            return false;
        }
        return isValidSmallBlock(board);
    }

    public boolean isValidLine(char[] line) {
        int[] valid = new int[9];
        for(char curNum : line) {
            if(curNum != '.') {
               int curNumInt = Integer.parseInt(String.valueOf(curNum));
               if(valid[curNumInt - 1] != curNumInt) {
                   valid[curNumInt - 1] = curNumInt;
               }else {
                   return false;
               }
            }
        }
        return true;
    }

    public boolean isValidVerticalLine(char[][] line) {
        for(int j = 0; j < 9; j++) {
            int[] valid = new int[9];
            for(int i = 0; i < 9; i++) {
                char curNum = line[i][j];
                if(curNum != '.') {
                    int curNumInt = Integer.parseInt(String.valueOf(curNum));
                    if (valid[curNumInt - 1] != curNumInt) {
                        valid[curNumInt - 1] = curNumInt;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSmallBlock(char[][] board) {
        for(int startV = 0; startV < 9; startV = startV + 3) {
            for(int startH = 0; startH < 9; startH = startH + 3) {
                int[] valid = new int[9];
                for(int j = startV; j < startV + 3; j++) {
                    for(int i = startH; i < startH + 3; i++) {
                        char curNum = board[i][j];
                        if(curNum != '.') {
                            int curNumInt = Integer.parseInt(String.valueOf(curNum));
                            if (valid[curNumInt - 1] != curNumInt) {
                                valid[curNumInt - 1] = curNumInt;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'}
                , {'.', '4', '.', '3', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '3', '.', '.', '1'}
                , {'8', '.', '.', '.', '.', '.', '.', '2', '.'}
                , {'.', '.', '2', '.', '7', '.', '.', '.', '.'}
                , {'.', '1', '5', '.', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '2', '.', '.', '.'}
                , {'.', '2', '.', '9', '.', '.', '.', '.', '.'}
                , {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(
                validSudoku.isValidSudoku(board)
        );
    }

}
