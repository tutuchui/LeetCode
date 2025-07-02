package classisc;

import java.util.Arrays;

//Leetcode 189
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[calculateNewIndex(nums.length, i, k)] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums1[i];
        }
    }

    public int calculateNewIndex(int length, int curIndex, int k) {
        return (curIndex + k) % length;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        rotateArray.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
