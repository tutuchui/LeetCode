import java.util.HashSet;

public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> hasSeen = new HashSet<>();
        int cur = n;
        while(true){
            if(hasSeen.contains(cur)){
                return false;
            }
            hasSeen.add(cur);
            cur = happySum(cur);
            if(cur == 1){
                return true;
            }

        }
    }

    private int happySum(int n){
        String strN = String.valueOf(n);
        char[] charN = strN.toCharArray();
        int sum = 0;
        for(char tmp : charN) {
            sum += Character.getNumericValue(tmp) * Character.getNumericValue(tmp);
        }
        return sum;
    }
}
