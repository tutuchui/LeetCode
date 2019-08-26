import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0){
            return true;
        }else{
           char[] sChar = s.toCharArray();
           char[] tChar = t.toCharArray();
           HashMap<Character,Character> hashMap = new HashMap<>();
           Set<Character> valueSet = new HashSet<>();
           for(int i = 0; i < sChar.length; i++){
               hashMap.put(sChar[i],tChar[i]);
           }
           for(int key : hashMap.keySet()){
               if(valueSet.contains(hashMap.get(key))){
                   return false;
               }
               valueSet.add(hashMap.get(key));
           }

           StringBuilder result = new StringBuilder();
           for(int i = 0; i < sChar.length;i++){
               result.append(hashMap.get(sChar[i]));
           }

           if(s.equals(result.toString())){
               return  true;
           }else{
               return false;
           }
        }
    }
}
