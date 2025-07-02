package classisc;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if(!map.containsKey(curS)) {
                map.put(curS, curT);
            }
            if(!map2.containsKey(curT)) {
                map2.put(curT, curS);
            }

            if(map.get(curS) != curT || map2.get(curT) != curS) {
                return false;
            }
        }

        return true;
    }
}
