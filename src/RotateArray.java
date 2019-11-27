public class RotateArray {
    public void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++){
            rotateOnce(nums);
        }

        int right = nums.length - 1 - k;
        int[] rotateNum  = new int[right];
        for(int i = 0; i < right; i++){
            rotateNum[i] = nums[k + 1 + i];
        }
        for(int i = nums.length - 1; i >= k; i--){
            nums[i] = nums[i-right];
        }
        for(int i = 0; i < right; i++){
            nums[i] = rotateNum[i];
        }

    }

    public void rotateOnce(int[] nums){
        int key = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 1; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = key;
    }
}
