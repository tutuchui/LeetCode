package graduate;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        int threshold = nums.length / 2;
        for(int key : map.keySet()){
            if(map.get(key) > threshold){
                return key;
            }
        }
        return -1;
    }
}
