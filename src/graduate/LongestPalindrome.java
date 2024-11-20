package graduate;

//Leetcode 5
public class LongestPalindrome {
    public String longestPalindrome(String s){
        int max = 0;
        String result = "";
//        for(int i = 0; i < s.length();i++){
//            for(int j = i + 1; j <= s.length();j++){
//                String tmp = s.substring(i,j);
//                if(isPalindrome(tmp)&&tmp.length() > max){
//                    max = tmp.length();
//                    result = tmp;
//                }
//            }
//        }
//        return result;
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        for(int curLen = 1; curLen <= length; curLen++){
            for(int start = 0; start < length; start++){
                int end = start + curLen - 1;
                if(end >= length){
                    break;
                }
                P[start][end] = (curLen == 1 || curLen == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if(P[start][end] && curLen > max){
                    max = curLen;
                    result = s.substring(start,end + 1);
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s){
        int mid = (s.length() - 1)/2;
        for(int i = 0; i <= mid; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
