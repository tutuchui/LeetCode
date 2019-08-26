import java.util.HashMap;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int result = -1;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] sChar = s.toCharArray();
        for(char c : sChar){
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c) + 1);
            }else{
                hashMap.put(c,1);
            }
        }

        for(int i = 0; i < s.length();i++){
            if(hashMap.get(sChar[i]) == 1){
                result = i;
                break;
            }
        }
        return  result;

    }
}
