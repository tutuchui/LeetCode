import java.util.Arrays;

//Leetcode 1877
public class MinimizeMaxPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for(int i = 0; i < nums.length/2; i++){
            int curSum = nums[i] + nums[nums.length - 1 - i];
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
