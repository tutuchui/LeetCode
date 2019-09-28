package DP;

public class DiceExp {
    public static void main(String[] args) {
        DiceExp diceExp = new DiceExp();
        int n = 2;
        int[] num = {2,2};
        System.out.println(diceExp.diceExp(n,num));
    }
    public double diceExp(int n, int[] num){
        int max = (int) Double.NEGATIVE_INFINITY;
        int prod = 1;
        for(int i : num){
            if(i > max){
                max = i;
            }
            prod *= i;
        }
        double[] res = new double[max + 1];
        res[1] = (double)1/prod;
        double tmpOld = res[1];
        for(int i = 2; i <= max; i++){
            double tmp = 1;
            for(int x : num){
                if(x >= i){
                    tmp *= (double) i/x;
                }
            }
            tmp -= tmpOld;
            tmpOld += tmp;
            res[i] = tmp;
        }
        double result = 0;
        for(int i = 1; i <= max; i++){
            result += res[i] * i;
        }
        return Double.valueOf(String.format("%.2f",result));
    }
}
