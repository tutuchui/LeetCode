import java.util.*;

public class SelectK {
    public static void main(String[] args) {
        SelectK selectK = new SelectK();
        selectK.solvePer(8);
//        selectK.solveSec(8,2);
    }
    public List<List<Integer>> solvePer(int n){
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> avaliableList = new HashSet<>();
        for(int i = 0;i < n; i++){
            avaliableList.add(i);
        }
        Iterator<Integer> iterator = avaliableList.iterator();
        for(int i = 0;i < n; i++){
            permutation(result,iterator.next(),avaliableList,new ArrayList<>());
        }
        System.out.println(result);
        return result;
    }

    public void permutation(List<List<Integer>> result,int selectedNumber, Set<Integer> avaliableList,List<Integer> currentList){
        currentList.add(selectedNumber);
        avaliableList = new HashSet<>(avaliableList);
        avaliableList.remove(selectedNumber);
        if(avaliableList.size() == 0) {
            result.add(currentList);
            return;
        }
        Iterator<Integer> iterator = avaliableList.iterator();
        for(int i = 0; i < avaliableList.size();i++){
            permutation(result,iterator.next(),avaliableList,new ArrayList<>(currentList));
        }
    }

    public List<Set<Integer>> solveSec(int n, int k){
        List<Set<Integer>> result = new ArrayList<>();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = i+1;
        }
        select(0,k,arr,new HashSet<Integer>(),result);
        System.out.println(result);
        return result;
    }

    public void select(int index, int k, int[] arr, HashSet<Integer> currentSet,List<Set<Integer>> result) {
        if(k == 1){
            for(int i = index; i < arr.length; i++){
                currentSet.add(arr[i]);
                result.add(new HashSet<Integer>(currentSet));
                currentSet.remove(arr[i]);
            }
        }else if(k > 1){
            for(int i = index; i <= arr.length - k;i++){
                currentSet.add(arr[i]);
                select(i + 1,k-1,arr,new HashSet<>(currentSet),result);
                currentSet.remove(arr[i]);
            }
        }
    }
}
