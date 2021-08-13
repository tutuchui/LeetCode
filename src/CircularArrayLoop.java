import java.util.Arrays;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int[] isReach = new int[nums.length];
            Arrays.fill(isReach, -1);
            int start = i;
            boolean startDirection = nums[start] > 0;
            int curStep = 0;
            isReach[start] = curStep;
            while(true){
                int next = start + nums[start];
                curStep++;
                if(next >= 0){
                    next = next % nums.length;
                }else{
                    while(next < 0){
                        next = next + nums.length;
                    }
                    next = next % nums.length;
                }

                boolean curDirection = nums[next] > 0;
                if(curDirection != startDirection){
                    break;
                }
                if(isReach[next] != - 1){
                    if(curStep - isReach[next] > 1){
                        return true;
                    }else{
                        break;
                    }
                }
                isReach[next] = curStep;
                start = next;
            }
        }
        return false;
    }
}
