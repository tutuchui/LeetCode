package classisc;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int end = 1;
        boolean isValidPrefix = true;
        String curPrefix = "";
        while(true) {
            if(end <= strs[0].length()) {
               curPrefix = strs[0].substring(0,end++);
            }else{
                return curPrefix;
            }
            for(String str: strs) {
                if(!str.startsWith(curPrefix)) {
                    if(curPrefix.length() > 1){
                        return curPrefix.substring(0 , curPrefix.length() - 1);
                    }else {
                        return "";
                    }
                }
            }
        }
    }
}
