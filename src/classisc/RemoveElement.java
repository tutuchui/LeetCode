package classisc;

import java.util.Arrays;

//Leetcode 27
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int count = 0;
        int[] indexArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                indexArr[count++] = i;
            }
        }

        for(int i = 0; i < count; i++) {
            nums[i] = nums[indexArr[i]];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
