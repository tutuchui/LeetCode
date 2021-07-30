import java.util.Arrays;
//Leetcode
public class FrequencyOfMostFrequentElement {
    public int maxFrequency(int[] nums, int k){
       Arrays.sort(nums);
       if(nums.length == 1){
           return 1;
       }
       if(nums[1] - nums[0] > k){
           return 1;
       }
       int maxItem = 1;
       for(int j = nums.length - 1; j > 0; j--){
           int remain = k;
           int curItem = 1;
           if(maxItem >= j + 1){
               break;
           }
           for(int i = j - 1; i >= 0; i--){
               int difference = nums[j] - nums[i];
               if(difference > remain){
                   break;
               }
               remain = remain - difference;
               curItem += 1;
           }
           if(curItem > maxItem){
               maxItem = curItem;
           }
       }

       return maxItem;
    }
}
