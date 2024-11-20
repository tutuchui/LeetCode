package graduate;

import java.util.*;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> availableList = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            availableList.add(num);
        }
        for(int i = 0; i < nums.length; i++){
            if(i == 0 ||  nums[i]!=nums[i-1]){
                permutation(result,nums[i],availableList,new ArrayList<>());
            }
        }
        return result;
    }

    public void permutation(List<List<Integer>> result, int selectedNumber, List<Integer> avaliableList, List<Integer> currentList) {
        currentList.add(selectedNumber);
        avaliableList = new ArrayList<>(avaliableList);
        avaliableList.remove((Object)selectedNumber);
        if (avaliableList.size() == 0) {
            result.add(currentList);
            return;
        }
        for (int i = 0; i < avaliableList.size(); i++) {
            if(i == 0 || avaliableList.get(i) != avaliableList.get(i-1))
            permutation(result, avaliableList.get(i), avaliableList, new ArrayList<>(currentList));
        }
    }
}
