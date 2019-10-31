import java.util.ArrayList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals){
        intervals = sortIntervals(intervals);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 0; i < intervals.length; i++){
            if(isOverlap(list.get(list.size()-1),intervals[i])){
                int[] temp = joinIntervals(list.get(list.size()-1),intervals[i]);
                list.remove(list.size()-1);
                list.add(temp);
            }else{
                list.add(intervals[i]);
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;

    }
    public int[][] sortIntervals(int[][] intervals){
       for(int i = 0; i < intervals.length; i++){
           for(int j = i; j < intervals.length; j++){
               if(intervals[i][0] > intervals[j][0]){
                   int[] temp = intervals[i];
                   intervals[i] = intervals[j];
                   intervals[j] = temp;
                }
           }
       }
       return intervals;
    }

    public boolean isOverlap(int[] left, int[] right){
        return left[1] >= right[0];
    }

    public int[] joinIntervals(int[] left, int[] right){
        if(left[1] > right[1]){
            return left;
        }else{
            return new int[]{left[0],right[1]};
        }
    }
}
