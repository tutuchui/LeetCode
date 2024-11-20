package graduate;

import java.util.ArrayList;
import java.util.List;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int[] numS = new int[nums.length + 1];
        numS[0] = 0;
        for(int i = 0; i < nums.length; i++){
            numS[i + 1] = nums[i];
        }
        List count = new ArrayList();
        dfs(numS,0,S,0, count,true);
        return count.size();
    }

    public int dfs(int[] numS, int sum, int S, int i, List count, boolean add){
        if(i >= numS.length){
            return 0;
        }
        if(add){
            sum += numS[i];
        }else{
            sum -= numS[i];
        }

        dfs(numS,sum,S,i+1,count,true);
        dfs(numS,sum,S,i+1,count,false);

        if(i == numS.length - 1&& sum == S){
            count.add("1");
        }

        return sum;

    }
}
