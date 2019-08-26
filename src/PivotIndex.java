public class PivotIndex {

    public int pivotIndex(int[] nums){
        if(nums.length <= 2){
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 1; i < nums.length;i++){
            rightSum += nums[i];
        }
        for(int mid = 1; mid < nums.length - 1; mid++){
            leftSum += nums[mid-1];
            rightSum -= nums[mid];
            if(leftSum == rightSum){
                return mid;
            }
        }

        return -1;
    }
}
