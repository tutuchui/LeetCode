public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = (int) Double.POSITIVE_INFINITY;
        int curLen = 0;
        int curSum = 0;
        boolean isExisted = false;
        for(int i = 0; i < nums.length; i++){
            curSum = nums[i];
            curLen = 1;
            if(curSum >= s){
                isExisted = true;
                if(curLen < minLen){
                    minLen = curLen;
                }
                break;
            }
            for(int j = i + 1; j < nums.length;j++){
                curSum += nums[j];
                curLen++;
                if(curSum >= s){
                    isExisted = true;
                    if(curLen < minLen){
                        minLen = curLen;
                    }
                    break;
                }
            }
        }
        if(isExisted){
            return minLen;
        }else{
            return 0;
        }
    }
    
}
