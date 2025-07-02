package classisc;

import java.util.Arrays;

//Leetcode 80
public class RemoveDuplicatesMedium {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3)  {
            return nums.length;
        }
        int count = 1;
        int curDupCount = 1;
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == cur && curDupCount < 2) {
                nums[count++] = nums[i];
                curDupCount++;
            }
            else if(nums[i] != cur) {
                nums[count++] = nums[i];
                cur = nums[i];
                curDupCount = 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesMedium removeDuplicate = new RemoveDuplicatesMedium();
        int count = removeDuplicate.removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}
