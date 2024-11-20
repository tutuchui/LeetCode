package citilearning;
//Leetcode 633
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i * i < c; i++) {
            int remain = c - i * i;
            double b = Math.sqrt(remain);
            if( b == (int)b) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
       long left = 0;
       long right = (long)Math.sqrt(c);
       while (left <= right) {
           long sum = left * left + right * right;
           if(sum == c) {
               return true;
           }
           if(sum > c) {
               right--;
           }
           if(sum < c ) {
               left ++;
           }
       }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum().judgeSquareSum(5));
    }
}
