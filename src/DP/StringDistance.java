package DP;

public class StringDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m==0){
            return n;
        }else if(n==0){
            return m;
        }
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[][] distance = new int[n+1][m+1];
        for(int i = 0; i <= m; i++){
            distance[0][i] = i;
        }
        for(int i = 0; i <= n; i++){
            distance[i][0] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m;j++){
                int temp = Math.min(distance[i-1][j] + 1,distance[i][j-1] + 1);
                int temp2 = 0;
                if(word1Array[m-1] == word2Array[n-1]){
                    temp2 = distance[i-1][j-1];
                }else{
                    temp2 = distance[i-1][j-1] + 1;
                }
                distance[i][j] = Math.min(temp,temp2);
            }
        }
        return distance[n][m];
    }
}
