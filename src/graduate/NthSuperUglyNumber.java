package graduate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Leetcode 313
public class NthSuperUglyNumber {

    //Straight forward way, would exceed time complexity
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        List<Integer> primesList = Arrays.stream(primes).boxed().collect(Collectors.toList());
        int count = 1;
        int curNum = 2;
        while (true){
            boolean isUglyNumber = true;
            for(int i = 2; i <= curNum; i++){
                if((curNum % i == 0) && isPrime(i) && !primesList.contains(i)){
                    isUglyNumber = false;
                    break;
                }
            }
            if(isUglyNumber){
                count++;
                if(count == n){
                    break;
                }
            }
            curNum++;
        }
        return curNum;
    }

    public int nthSuperUglyNumberDP(int n, int[] primes){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int primesLength = primes.length;
        int[] pointers = new int[primesLength];
        Arrays.fill(pointers,1);
        for(int i = 2; i <= n; i++){
            int minNum = Integer.MAX_VALUE;
            int[] nums = new int[primesLength];
            for(int j = 0; j < primesLength; j++){
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(nums[j], minNum);
            }
            dp[i] = minNum;
            for(int j = 0; j < primesLength; j++){
                if(nums[j] == minNum){
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
    public boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if( n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] primes = new int[]{2,7,13,19};
        System.out.println(new NthSuperUglyNumber().nthSuperUglyNumber(12, primes));
    }
}
