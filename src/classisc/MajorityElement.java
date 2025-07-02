package classisc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Leetcode 169
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    //摩尔投票法
    public int majorityElement3(int[] nums) {
        int x = nums[0]; //假设第一个数为众数
        int vote = 0;
        for(int num : nums) {
            if(vote == 0) {
                x = num;
            }
           if(num == x) {
               vote++;
           }else {
               vote--;
           }
        }
        return x;
    }
}
