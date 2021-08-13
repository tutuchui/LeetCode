//Leetcode 413
public class ArithmeticsSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int totalCount = 0;
        for(int start = 0; start <= nums.length - 3; start++){
            int numberOfEle = 3;
            while (true){
                int end = start + numberOfEle - 1;
                if((end < nums.length) && isArithmeticsSlices(nums, start, end)){
                    totalCount++;
                    numberOfEle++;
                }else{
                    break;
                }
            }
        }
        return totalCount;
    }

    boolean isArithmeticsSlices(int[] nums, int start, int end){
        int slice = nums[start + 1] - nums[start];
        for(int i = start; i < end; i++){
             int curSlice = nums[i+1] - nums[i];
             if(curSlice != slice){
                 return false;
             }
        }
        return true;
    }
}
