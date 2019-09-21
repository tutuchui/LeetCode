public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        int i = 0;
        while(matrix[i][n-1] <= target){
            i++;
        }
        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(matrix[i][mid] == target){
                return true;
            }
            else if(matrix[i][mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}
