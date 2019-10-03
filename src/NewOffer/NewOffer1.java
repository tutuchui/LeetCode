public class NewOffer1 {
    public boolean Find(int target, int[][] array){
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        int low = 0; int high = cols - 1;
        for(int i = 0; i < array.length; i++) {
            while (low <= high){
                int mid = low + (high - low)/2;
                if(array[i][mid] > target){
                    high = mid - 1;
                }else if(array[i][mid] < target){
                    low = mid + 1;
                }else{
                    return true;
                }
            }
        }
        return false;

    }

}
