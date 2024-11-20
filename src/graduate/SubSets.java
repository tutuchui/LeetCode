package graduate;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
       for(int i = 1; i <= nums.length; i++){
           subsets.addAll(selectK(nums,i));
       }
       return subsets;

    }

    public List<List<Integer>> selectK(int[] nums, int k){
        List<List<Integer>> result = new ArrayList<>();
        select(0,k,nums,new ArrayList<>(),result);
        return result;
    }

    public void select(int index, int k, int[] nums, List<Integer> curList, List<List<Integer>> result){
        if(k == 1){
            for(int i = index; i < nums.length; i++){
                curList.add(nums[i]);
                result.add(new ArrayList<>(curList));
                curList.remove((Object)nums[i]);
            }
        }else{
            for(int i = index; i <= nums.length - k; i++){
                curList.add(nums[i]);
                select(i+1,k-1,nums,curList,result);
                curList.remove((Object)nums[i]);
            }
        }
    }
}
