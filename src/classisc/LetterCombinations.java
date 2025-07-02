package classisc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> letterMaps = new HashMap<Character, List<String>>();
        letterMaps.put('2', List.of("a", "b","c"));
        letterMaps.put('3', List.of("d", "e","f"));
        letterMaps.put('4', List.of("g", "h","i"));
        letterMaps.put('5', List.of("j", "k","l"));
        letterMaps.put('6', List.of("m", "n","o"));
        letterMaps.put('7', List.of("p", "q","r","s"));
        letterMaps.put('8', List.of("t", "u","v"));
        letterMaps.put('9', List.of("w", "x","y", "z"));
        List<String> res = new ArrayList<String>();
        combine(res, letterMaps, "", 0, digits);
        return res;
    }

    public void combine(List<String> res, Map<Character, List<String>> letterMaps, String curRes, int curIndex, String digits) {
        List<String> curDigitalLetters = letterMaps.get(digits.charAt(curIndex));
        for(String letter: curDigitalLetters) {
            String newCurRes = curRes + letter;
            if(curIndex == digits.length() - 1) {
                res.add(newCurRes);
            }else{
                combine(res, letterMaps, newCurRes, curIndex + 1, digits);
            }
        }

    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }


}
