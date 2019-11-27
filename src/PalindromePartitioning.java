import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> finalResult = new ArrayList<>();
        List<Integer> availableSplitPoint = new ArrayList<>();
        if(s.length() == 1){
            List<String> sList = new ArrayList<>();
            sList.add(s);
            finalResult.add(sList);
            return finalResult;
        }
        for(int i = 1; i < s.length(); i++){
            availableSplitPoint.add(i);
        }
        for(int i = 0; i < availableSplitPoint.size(); i++){
            List<List<Integer>> result = new ArrayList<>();
            getPossibleSplitPoint(0,i,availableSplitPoint,new ArrayList<>(),result);
            for(List<Integer> tmp : result){
                List<String> splitedString = splitString(s,tmp);
                if(isPalindromeList(splitedString)){
                    finalResult.add(splitedString);
                }
            }
        }
        return finalResult;
    }

    public boolean isPalindrome(String s){
        int mid = (s.length()-1)/2;
        for(int i = 0; i <= mid; i++){
            if(s.charAt(i)!=s.charAt(s.length() - 1- i)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeList(List<String> sList){
        for(String string :  sList){
            if(!isPalindrome(string)){
                return false;
            }
        }
        return true;
    }

    public List<String> splitString(String s, List<Integer> splitPoint){
        List<String> result = new ArrayList<>();
        if(splitPoint.size() == 0){
            result.add(s);
            return result;
        }
        result.add(s.substring(0,splitPoint.get(0)));
        for(int i = 0; i < splitPoint.size() - 1; i++){
            result.add(s.substring(splitPoint.get(i),splitPoint.get(i+1)));
        }
        result.add(s.substring(splitPoint.get(splitPoint.size() -1)));
        return result;
    }

    public void getPossibleSplitPoint(int index, int splitTime, List<Integer> availableSplitPoint, List<Integer> curList,List<List<Integer>> result){
        if(splitTime == 0){
            return;
        }
        if(splitTime == 1){
            for(int i = index; i < availableSplitPoint.size(); i++){
                curList.add(availableSplitPoint.get(i));
                result.add(new ArrayList<>(curList));
                curList.remove((Object)availableSplitPoint.get(i));
            }
        }else if(splitTime > 1){
            for(int i = index; i < availableSplitPoint.size() - splitTime; i++){
                curList.add(availableSplitPoint.get(i));
                getPossibleSplitPoint(i + 1,splitTime - 1, availableSplitPoint,curList,result);
                curList.remove((Object)availableSplitPoint.get(i));
            }
        }
    }
}
