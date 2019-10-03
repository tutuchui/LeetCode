public class NewOffer2 {
    public String replaceSpace(StringBuffer str) {
        for(int i = 0; i < str.length();){
            if(str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
                i = i + 2;
            }
            i = i + 1;
        }
        return str.toString();
    }
}
