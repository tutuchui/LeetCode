package graduate;

public class BinarySearch {
    public int search(int[] nums, int target) {
//        return binarySearch(nums,target,0,nums.length - 1);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return -1;
    }

}
