package graduate;

public class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
       int[] result = new int[]{-1,-1};
        int firstPos = findFirstElement(0,nums.length-1,nums,target);
        if(firstPos != -1){
            result[0] = firstPos;
        }else{
            return result;
        }
        int lastPos = findLastElement(firstPos,nums.length-1,nums,target);
        result[1] = lastPos;
        return result;
    }

    public int findFirstElement(int left, int right, int nums[], int target){
        while(left < right){
            int mid = left + (right - left) /2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(nums[left]== target){
            return left;
        }else{
            return -1;
        }
    }


    public int findLastElement(int left, int right, int[] nums, int target){
        while(left < right){
            int mid = left + (right - left + 1) /2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        if(nums[right] == target){
            return right;
        }else{
            return -1;
        }
    }
}
