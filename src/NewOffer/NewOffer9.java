package NewOffer;

public class NewOffer9 {
    public int JumpFloorII(int target) {
        int result = 0;
        if(target == 1 || target == 0){
            return 1;
        }else{
            for(int i = target - 1; i >= 0; i--){
                result += JumpFloorII(i);
            }
        }
        return result;
    }
}
