//Leetcode 125
public class ValidPalindrome {
    public boolean isPalindrome(String s){
        if(s.equals("")){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                sb.append(c);
            }
        }
        String finalStr = sb.toString();
        if(finalStr.equals("")){
            return true;
        }
        int mid = (finalStr.length()-1)/2;
        for(int i = 0; i <= mid; i++){
            if(finalStr.charAt(i)!=finalStr.charAt(finalStr.length() - 1- i)){
                return false;
            }
        }
        return true;
    }
}
