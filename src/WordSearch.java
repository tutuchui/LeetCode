import java.util.ArrayList;
//Leetcode
public class WordSearch {
    public static int[][] DIRECTIONS= {{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        if(word.length() == 0){
            return true;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(search(board,word,i,j,0,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int row, int col,int index, boolean[][] isVisited){
        if(index == word.length() - 1){
            return board[row][col] == word.charAt(word.length() - 1);
        }
        if(board[row][col] == word.charAt(index)){
            isVisited[row][col] = true;
            for(int i = 0; i < DIRECTIONS.length ; i++){
                int new_row = row + DIRECTIONS[i][0];
                int new_col = col + DIRECTIONS[i][1];
                if(isValidPos(new_row,new_col,board.length,board[0].length) && !isVisited[new_row][new_col]){
                    if(search(board,word,new_row,new_col,index + 1,isVisited)){
                        return true;
                    }
                }
            }
            isVisited[row][col] = false;
        }

        return false;
    }

    public boolean isValidPos(int i, int j, int row, int col){
        if(i >= 0 && i < row && j >= 0 && j < col){
            return true;
        }
        return false;
    }


}
