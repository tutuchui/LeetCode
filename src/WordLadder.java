//Leetcode 127
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> queue2 = new LinkedList<>();
        queue.add(beginWord);
        boolean[] isVisited = new boolean[wordList.size()];
        int step = 0;
        while(!queue.isEmpty()){
            String cur = queue.removeFirst();
            if (cur.equals(endWord)) {
                return step;
            }
            for(int i = 0; i < wordList.size();i++){
                if(stringDistance(cur,wordList.get(i)) == 1 && !isVisited[i]){
                    queue2.add(wordList.get(i));
                    isVisited[i] = true;
                }
            }
            if(queue.isEmpty()){
                queue = queue2;
                queue2 = new LinkedList<>();
                step++;
            }
        }
        return 0;
    }

    public int stringDistance (String left, String right){
        int distance = 0;
        for(int i = 0; i < left.length();i++){
            if(left.charAt(i) != right.charAt(i)){
                distance ++;
            }
        }
        return distance;
    }
}
