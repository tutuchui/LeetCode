package classisc;

import java.util.*;

//Leetcode 383
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
       Map<Character, Integer> setMap = new HashMap<>();
        if(magazine.isEmpty()) {
            return false;
        }
        for(char a : magazine.toCharArray()) {
            if(setMap.containsKey(a)) {
                setMap.put(a, setMap.get(a) + 1);
            }else{
                setMap.put(a, 1);
            }
        }
        for(char a : ransomNote.toCharArray()) {
            if(setMap.containsKey(a) && setMap.get(a) >= 1) {
                setMap.put(a, setMap.get(a) - 1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        System.out.println(canConstruct.canConstruct("aa", "aab"));
    }
}
