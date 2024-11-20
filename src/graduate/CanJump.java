package graduate;

//LeetCode 55
public class CanJump {
    public boolean canJump(int[] nums){
        boolean[] isReachable = new boolean[nums.length];
        isReachable[0] =true;
        for(int i = 0; i < isReachable.length - 1;i++){
            if(isReachable[i]){
                for(int j = i + 1; j <= i + nums[i]; j++){
                    if(j < isReachable.length){
                        isReachable[j] = true;
                    }
                }
            }
        }
        return isReachable[nums.length - 1];
    }
}
