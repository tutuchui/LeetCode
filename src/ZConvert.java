public class ZConvert {
    public  String convert(String s, int numRows){
        if(s.length() == 0){
            return "";
        }
        if(s.length() <= numRows || numRows == 1){
            return s;
        }
        int[][] direction = {{1,0},{-1,1}};
        int lenPerSet = numRows + numRows - 2;
        int set = s.length() / lenPerSet;
        int remainder = s.length() - lenPerSet * set;
        int remainCol;
        if(remainder == 0){
            remainCol = 0;
        }
        else if(remainder > 0 && remainder <= numRows){
            remainCol = 1;
        }else{
            remainCol = 1 + remainder - numRows;
        }
        int cols = set * (numRows - 1) + remainCol;

        char[][] output = new char[numRows][cols];
        for(int i = 0; i < output.length;i++){
            for(int j = 0; j < output[i].length;j++){
                output[i][j] = ' ';
            }
        }
        int i = 0,j = 0,curChar = 0;
        int m = 0;
        int[] curDirection = direction[m];
        while(true){
            output[i][j] = s.charAt(curChar);
            curChar++;
            if(curChar == s.length()){
                break;
            }
            int new_i = i + curDirection[0];
            int new_j = j + curDirection[1];
            while(!isValidPos(new_i,new_j,numRows,cols)){
                curDirection = direction[(++m % direction.length)];
                 new_i = i + curDirection[0];
                 new_j = j + curDirection[1];
            }
            i = new_i;
            j = new_j;
        }
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < output.length;x++){
            for(int y = 0; y < output[x].length;y++){
                if(output[x][y]!=' '){
                    result.append(output[x][y]);
                }
            }
        }
        return result.toString();
    }

    public boolean isValidPos(int i, int j,int rows, int cols){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        ZConvert zConvert = new ZConvert();
        zConvert.convert("LEETCODEISHIRING",3);
    }
}
