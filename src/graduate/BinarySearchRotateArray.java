package graduate;

public class BinarySearchRotateArray {
    public static void main(String[] args) {
        int[] nums = {4,5,1,2,3};
        BinarySearchRotateArray b = new BinarySearchRotateArray();
        System.out.println(b.search(nums,1));
    }
    public int search(int[] nums, int target) {
        if(nums.length <= 1){
            if(nums.length == 0){
                return -1;
            }
            else if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }
        int rotateIndex = find_rotate_index(0,nums.length - 1,nums);
        if(nums[rotateIndex] <= target && nums[nums.length - 1] >= target){
           return binarySearch(rotateIndex,nums.length -1,nums,target);
        }else{
            return binarySearch(0,rotateIndex -1,nums,target);
        }
    }

    public int binarySearch(int left, int right, int[] nums, int target){
        while(left <= right){
            int mid = left + (right - left )/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public int find_rotate_index(int left, int right,int[] nums){
        if(nums[left] < nums[right]){
            return 0;
        }
        while(left < right){
            System.out.println("l: "+left + " r: "+right);
            int pivot = left + (right-left)/2;
            if(nums[pivot] > nums[pivot+1]){
                return pivot + 1;
            }else {
                if(nums[pivot] >= nums[left]){
                    left = pivot + 1;
                }else{
                    right = pivot;

                }
            }
        }
        return 0;

    }
}
