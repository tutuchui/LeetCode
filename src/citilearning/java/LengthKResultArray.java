package citilearning;

import java.util.Arrays;

public class LengthKResultArray {
    public int[] resultsArray(int[] nums, int k) {
        int totalSize = nums.length - k + 1;
        int[] result = new int[totalSize];
        for(int i = 0; i < nums.length - k + 1; i++) {
            int power = checkPower(nums, i, i + k);
            result[i] = power;
        }

        return result;
    }

    public int checkPower(int[] nums, int start, int end) {
        for(int i = start; i < end - 1; i++) {
            if(nums[i + 1] - nums[i] != 1) {
                return -1;
            }
        }

        return nums[end - 1];
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{1,2,3,4,3,2,5};
        System.out.println(Arrays.toString(new LengthKResultArray().resultsArray(testArray, 3)));
    }
}
