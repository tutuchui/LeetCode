import com.sun.xml.internal.fastinfoset.util.StringIntMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
       List<Integer> mapping = new ArrayList<>();
       List<String> nums = new ArrayList<>();
       mapping.add(2);
        mapping.add(1);
        mapping.add(4);
        mapping.add(8);
        mapping.add(6);
        mapping.add(3);
        mapping.add(0);
        mapping.add(9);
        mapping.add(7);
        mapping.add(5);
        nums.add("12");
        nums.add("02");
        nums.add("4");
        nums.add("023");
        nums.add("65");
        nums.add("83");
        nums.add("224");
        nums.add("50");
//        System.out.println(main.strangeSort(mapping,nums));
        System.out.println(main.compareString("000034","0154"));

    }

    public ArrayList<String> strangeSort(List<Integer> mapping, List<String> nums){
        HashMap<String,String> stringMap = new HashMap<>();
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<String> mappedStringList = new ArrayList<>();
        for(String num : nums){
            String mappedString = stringMap(num,mapping);
            stringMap.put(num,mappedString);
            mappedStringList.add(mappedString);
        }
        sortString(mappedStringList);
        for(int i = 0; i < mappedStringList.size(); i++){
            for(String num : nums){
                if(stringMap.get(num).equals(mappedStringList.get(i))){
                    resultList.add(num);
                    nums.remove(num);
                    break;
                }
            }
        }
        return resultList;

    }

    public String stringMap(String original, List<Integer> mapping){
        StringBuilder result = new StringBuilder();
        for(char curChar : original.toCharArray()){
            for(int i = 0; i < mapping.size();i++){
                if(Character.getNumericValue(curChar) == mapping.get(i)){
                    result.append(i);
                    break;
                }
            }
        }
        return result.toString();
    }

    public int compareString(String left, String right){
        String tmpLeft = left;
        String tmpRight = right;
        for(int cur = 0; cur < left.length(); cur++){
            if(left.charAt(cur)!= '0'){

                break;
            }else{
                System.out.println(cur);
                tmpLeft = left.substring(cur+1);
            }
        }
        for(int cur = 0; cur < right.length(); cur++){
            if(right.charAt(cur)!= '0'){
                break;
            }else{
                tmpRight = right.substring(cur+1);
            }
        }
        System.out.println(tmpLeft + " " + tmpRight);
        if(tmpLeft.length() > tmpRight.length()){
            return 1;
        }else if(tmpLeft.length() < tmpRight.length()){
            return -1;
        }else{
            for(int i = 0; i < tmpLeft.length(); i++){
                if(tmpLeft.charAt(i) > tmpRight.charAt(i)){
                    return 1;
                }else if(tmpLeft.charAt(i) < tmpRight.charAt(i)){
                    return -1;
                }
            }
        }
        return 0;
    }

    public void sortString(List<String> mappedString){
        for(int i = mappedString.size() -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(compareString(mappedString.get(j),mappedString.get(j+1))==1){
                    String temp = mappedString.get(j);
                    mappedString.set(j,mappedString.get(j+1));
                    mappedString.set(j+1,temp);
                }
            }
        }
    }
}


