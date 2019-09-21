public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int sum = 0;
        int result = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > result){
                result = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return result;
    }
}
