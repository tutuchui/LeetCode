public class ReverseString {
    public void reverseString(char[] s) {
        if(s.length == 0){
            return;
        }
        reverse(s,0);
    }

    public void reverse(char[] s, int index){
        if(index == s.length -1){
            return;
        }
        reverse(s,index + 1);
        char c = s[index];
        for(int i = index + 1; i < s.length; i++){
            s[i - 1] = s[i];
        }
        s[s.length - 1] = c;
    }
}
