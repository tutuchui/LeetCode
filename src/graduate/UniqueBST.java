package graduate;

//Leetcode 96
public class UniqueBST {
    public int numTrees(int n){
        if(n == 0){
            return 0;
        }
        int[] dpTrees = new int[n+1];
        dpTrees[0] = 1;
        dpTrees[1] = 1;
        if(n >= 2){
            dpTrees[2] = 2;
        }
        if(n >= 3){
            for(int i = 3; i <= n; i++) {
                int curTree = 0;
                for (int root = 1; root <= i; root++) {
                    int left = root - 1;
                    int right = i - root;
                    curTree += dpTrees[left] * dpTrees[right];
                }
                dpTrees[i] = curTree;
            }
        }
        return dpTrees[n];
    }
}
