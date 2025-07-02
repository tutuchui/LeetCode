package classisc;

import java.util.Arrays;
//Leetcode 26
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1)  {
            return nums.length;
        }
        int count = 1;
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != cur) {
                nums[count] = nums[i];
                cur = nums[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4};
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int count = removeDuplicate.removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}
