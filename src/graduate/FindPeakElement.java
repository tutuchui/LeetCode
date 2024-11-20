package graduate;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return search(0,nums.length-1,nums);
    }

    public int search(int left, int right, int[] nums){
        if(left == right){
            return left;
        }
        int mid = left + (right - left)/2;
        if(nums[mid] > nums[mid+1]){
           return search(left,mid,nums);
        }else{
            return search(mid+1,right,nums);
        }
    }
}
