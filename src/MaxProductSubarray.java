public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax * nums[i],nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);

            max = Math.max(max,curMax);
        }
        return max;
    }


}
