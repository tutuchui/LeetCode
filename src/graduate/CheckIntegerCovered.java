package graduate;

//Leetcode 1893
public class CheckIntegerCovered {
    public boolean isCovered (int[][] ranges, int left, int right){
        boolean[] results = new boolean[right - left + 1];
        int index = 0;
        for(int i = left; i<= right; i++){
            for (int[] range : ranges) {
                int leftTemp = range[0];
                int rightTemp = range[1];
                if (i >= leftTemp && i <= rightTemp) {
                    results[index] = true;
                    break;
                }
            }
            index++;
        }
        for(boolean result : results){
            if(!result){
                return false;
            }
        }
        return true;
    }
}
