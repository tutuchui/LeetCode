public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length - 1);
    }
    public int binarySearch(int[] nums, int target, int start,int end){
        if(end - start <= 1) {
            if (nums[end] == target) {
                return end;
            } else if((nums[start] == target)) {
                return start;
            }else {
                return -1;
            }
        }
        int mid = (start + end) /2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return binarySearch(nums,target,mid+1,nums.length-1);
        }else{
            return binarySearch(nums,target,start,mid);
        }

    }

}
