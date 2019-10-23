package NewOffer;

public class NewOffer11 {
    public int NumberOf1(int n) {
        int result = 0;
        while(n!=0){
            result++;
            n = n & (n-1);
        }
        return result;
    }
}
