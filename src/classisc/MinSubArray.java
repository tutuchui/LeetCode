package classisc;

public class MinSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 1;
        int minLen = Integer.MAX_VALUE;
        int curSum = nums[start];
        while(true) {
            if(curSum < target && end < nums.length) {
                curSum += nums[end];
                end++;
            }else if(curSum >= target) {
                minLen = Math.min(minLen, end - start);
                curSum -= nums[start];
                start++;
            }else {
                break;
            }
        }
        if(minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        MinSubArray minSubArray = new MinSubArray();
        System.out.println(minSubArray.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
