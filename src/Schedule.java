import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Schedule {

    static int schedule(int m,int[] array) {
        int min = (int)Double.POSITIVE_INFINITY;
        List<List<Integer>> possSet = solveSec(array.length - 1,m-1);
        for(List<Integer> list : possSet){
            list.add(0,0);
            int max = (int)Double.NEGATIVE_INFINITY;
            for(int i = 0; i < list.size(); i++){
                int current = 0;
                if(i != list.size() - 1) {
                    for (int j = list.get(i); j < list.get(i + 1) - 1; j++) {
                        current += array[j];
                    }
                }else{
                    for (int j = list.get(i); j < list.size() - 1; j++) {
                        current += array[j];
                    }
                }
                if(current > max){
                    max = current;
                }
            }
            if(max <= min){
                min = max;
            }
        }
        return min;
    }

    public static List<List<Integer>> solveSec(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = i+1;
        }
        select(0,k,arr,new ArrayList<Integer>(),result);
        System.out.println(result);
        return result;
    }

    public static void select(int index, int k, int[] arr, List<Integer> currentSet,List<List<Integer>> result) {
        if(k == 1){
            for(int i = index; i < arr.length; i++){
                currentSet.add(arr[i]);
                result.add(new ArrayList<>(currentSet));
                currentSet.remove(arr[i]);
            }
        }else if(k > 1){
            for(int i = index; i <= arr.length - k;i++){
                currentSet.add(arr[i]);
                select(i + 1,k-1,arr,new ArrayList<>(currentSet),result);
                currentSet.remove(arr[i]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
