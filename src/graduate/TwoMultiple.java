package graduate;

import java.util.ArrayList;

public class TwoMultiple {
    public ArrayList<IntPair> findTwoMultiple(int[] nums, int target){
        ArrayList<IntPair> result = new ArrayList<>();
        int i = 0; int j = nums.length -1;
        while(i < j){
            if(nums[i] * nums[j] == target) {
                IntPair tmp = new IntPair(nums[i], nums[j]);
                result.add(tmp);
                i++;
                j--;
            }else if(nums[i] * nums[j] < target){
                i++;
            }else if(nums[i] * nums[j] > target){
                j--;
            }
        }
        if(result.size() == 0){
            result.add(new IntPair(-1,-1));
        }
        return result;
    }

    public static void main(String[] args) {
        TwoMultiple twoMultiple = new TwoMultiple();
        int[] nums = {1,2,4,5,7,8,11,12,15};
        System.out.println(twoMultiple.findTwoMultiple(nums,64));
    }
}

class IntPair{
    public int first;
    public int second;

    public IntPair(int first, int second){
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return "[" + this.first + "," + this.second + "]";
    }
}
