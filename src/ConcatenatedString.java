import java.util.*;

public class ConcatenatedString {
    public static void main(String[] args) {
        ConcatenatedString concatenatedString = new ConcatenatedString();
        String[] words = {"a","a"};
        String s = "aaa";
        System.out.println(concatenatedString.findSubstring(s,words));

    }
    public List<Integer> findSubstring(String s, String[] words) {
        int length = words.length;
        List<Integer> result = new ArrayList<>();
        HashSet<String> allSubStr = new HashSet<>();
        List<List<Integer>> allComb = solvePer(length);
        for(List<Integer> tmp : allComb){
            StringBuilder sb = new StringBuilder();
            for(int num : tmp){
                sb.append(words[num]);
            }
            allSubStr.add(sb.toString());
        }

        for(String sub : allSubStr){
           int startIndex = 0;
           while(s.indexOf(sub,startIndex)!= -1){
               int tmp = s.indexOf(sub,startIndex);
               if(!result.contains(tmp)){
                   result.add(tmp);
               }
               startIndex = tmp + sub.length();

           }
        }
        return result;
    }

    public List<List<Integer>> solvePer(int n){
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> avaliableList = new HashSet<>();
        for(int i = 0;i < n; i++){
            avaliableList.add(i);
        }
        Iterator<Integer> iterator = avaliableList.iterator();
        for(int i = 0;i < n; i++){
            permutation(result,iterator.next(),avaliableList,new ArrayList<>());
        }
//        System.out.println(result);
        return result;
    }

    public void permutation(List<List<Integer>> result,int selectedNumber, Set<Integer> avaliableList,List<Integer> currentList){
        currentList.add(selectedNumber);
        avaliableList = new HashSet<>(avaliableList);
        avaliableList.remove(selectedNumber);
        if(avaliableList.size() == 0) {
            result.add(currentList);
            return;
        }
        Iterator<Integer> iterator = avaliableList.iterator();
        for(int i = 0; i < avaliableList.size();i++){
            permutation(result,iterator.next(),avaliableList,new ArrayList<>(currentList));
        }
    }

}
