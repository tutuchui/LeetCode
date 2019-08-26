public class MyPow {
    public double myPowNormal(double x, int n) {
        long N = n;
        double result = 1;
        if (N < 0) {
            N = -n;
            x = 1 / x;
        }
        for (long i = 0; i < N; i++) {
            result *= x;
        }
        return result;
    }

    public double myPowRegress(double x, int n) {
        int N = n;
        if (N < 0) {
            N = -n;
            x = 1 / x;
        }
        return fastPow(x,N);
    }

    public double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }else if(n == 1){
            return x;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }else{
            return half * half * x;
        }
    }

}
