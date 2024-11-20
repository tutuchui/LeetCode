package graduate;

//Leetcode 28
public class StrStr {
    public int strStr(String haystack, String needle) {
        int cur = 0;
        int nLength = needle.length();
        if(nLength == 0){
            return 0;
        }
        while(cur <= haystack.length() - nLength){
            if(haystack.substring(cur,cur + nLength).equals(needle)){
                return cur;
            }
            cur++;
        }
        return -1;
    }
}
