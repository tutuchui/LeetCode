public class MySqrt {
    public int mySqrt(int x) {
        long left = 0;
        long right = x/2 + 1;

        while(right > left){
            long mid = left + (right - left + 1)/2;
            long square = mid * mid;
            if (square > x){
                right = mid - 1;
            }else{
                left = mid;
            }
        }

        return (int) left;
    }
}
