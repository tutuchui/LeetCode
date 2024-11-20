package graduate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> availableList = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length;i++){
            availableList.add(candidates[i]);
        }

        for(int i = 0; i < availableList.size();i++){
            if(availableList.get(i) <= target && (i == 0 || availableList.get(i)!= availableList.get(i-1))){
                combine(result,new ArrayList<>(),0,availableList.get(i),availableList.subList(i,availableList.size()),target);
            }
        }
        return result;

    }

    public void combine(List<List<Integer>> result, List<Integer> currentList, int currentSum, int selectedNum, List<Integer> availableList, int target){
        currentSum += selectedNum;
        availableList = new ArrayList<>(availableList);
        if(currentSum < target){
            currentList.add(selectedNum);
        }else if(currentSum == target){
            currentList.add(selectedNum);
            result.add(currentList);
            return;
        }else{
            return;
        }
        availableList.remove((Object) selectedNum);
        for(int i = 0; i < availableList.size();i++){
            if(availableList.get(i) <= target - currentSum && (i == 0 || availableList.get(i)!= availableList.get(i-1))){
                combine(result,new ArrayList<>(currentList),currentSum,availableList.get(i),availableList,target);
            }
        }
    }
}
