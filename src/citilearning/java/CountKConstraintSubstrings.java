package citilearning.java;

import java.util.Arrays;

public class CountKConstraintSubstrings {
    public int countKConstraintSubstrings(String s, int k) {
        int totalCount = 0;
        for(int subStringLength = 1; subStringLength <= s.length(); subStringLength++) {
            for(int i = 0; i <= s.length() - subStringLength; i++) {
                if(isValid(s.substring(i, i+subStringLength), k)){
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

    public boolean isValid(String s, int k) {
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if('0' == s.charAt(i)) {
                zeroCount++;
            }
            if('1' == s.charAt(i)) {
                oneCount++;
            }
        }
        return zeroCount <= k || oneCount <= k;
    }

    public int countKConstraintSubstrings2(String s, int k) {
        int l = 0; int ans = 0;
        int[] count = new int[2];
        for(int r = 0; r < s.length(); r++) {
            ++count[s.charAt(r) - '0'];
            while(count[0] > k && count[1] > k) {
                count[s.charAt(l) - '0']--;
                l = l + 1;
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        long[] result = new long[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String curS = s.substring(queries[i][0], queries[i][1] + 1);
            result[i] = countKConstraintSubstrings2(curS, k);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountKConstraintSubstrings().countKConstraintSubstrings("0001111", 2, new int[][]{{0, 6}})));
        System.out.println(Arrays.toString(new CountKConstraintSubstrings().
                countKConstraintSubstrings("010101", 1, new int[][]{{0, 5}, {1,4}, {2,3}})));

    }
}
