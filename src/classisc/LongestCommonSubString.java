package classisc;

import java.util.Locale;

public class LongestCommonSubString {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.isEmpty()) {
            return 0;
        }
        int start = 0;
        int end = 1;
        int longestCommonSubsequence = 0;
        String curSubstring = "";
        while(end <= text1.length()) {
             curSubstring =  text1.substring(start,end);

             if(text2.contains(curSubstring)) {
                 longestCommonSubsequence = end - start;
                 end++;
             }else {
                 start++;
                 end++;
             }
        }
        return longestCommonSubsequence;

    }

    public String longestCommonSubsequence2(String[] strs) {
        if(strs[0].isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 1;
        String curSubstring = "";
        String validSubstring = "";
        while(end <= strs[0].length()) {
            curSubstring =  strs[0].toLowerCase(Locale.ROOT).substring(start,end);
            boolean isValid = true;
            for(int i = 1; i < strs.length; i++) {
                if(!strs[i].toLowerCase(Locale.ROOT).contains(curSubstring)) {
                    isValid = false;
                    start++;
                    end++;
                    break;
                }
            }
            if(isValid) {
                validSubstring = curSubstring;
                end++;
            }
        }
        return validSubstring;
    }

    public static void main(String[] args) {
        LongestCommonSubString lcs = new LongestCommonSubString();
//        System.out.println(lcs.longestCommonSubsequence("aced", "ace"));
        String[] strs = new String[] {"rose","roy","Roswood","rosmarry","roshh"};
        System.out.println(lcs.longestCommonSubsequence2(strs));
    }
}
