import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target){
        String initial = "0000";
        HashSet<String> deadList = new HashSet<>(Arrays.asList(deadends));
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        HashSet<String> testedCode = new HashSet<>();
        if(deadList.contains(target) || deadList.contains(initial)){
            return -1;
        }
        queue.offer(initial);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(cur.equals(target)){
                return step;
            }
            List<String> rotatedString = rotateLock(cur);
            for(String rotate : rotatedString){
                if(!deadList.contains(rotate) && !testedCode.contains(rotate)){
                    testedCode.add(rotate);
                    queue2.offer(rotate);
                }
            }

            if(queue.isEmpty()){
                step++;
                queue = queue2;
                queue2 = new LinkedList<>();
            }

        }

        return -1;
    }


    public List<String> rotateLock(String cur){
        List<String> nextList = new LinkedList<>();
        for(int i = 0; i < 4; i++) {
            char curChar = cur.charAt(i);
            char newChar;
            if(curChar != '9'){
                newChar = (char) (curChar + 1);
            }else{
                newChar = '0';
            }
            StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i,newChar);
            nextList.add(builder.toString());

            if(curChar != '0'){
                newChar = (char) (curChar - 1);
            }else{
                newChar = '9';
            }
            builder = new StringBuilder(cur);
            builder.setCharAt(i,newChar);
            nextList.add(builder.toString());
        }
        return nextList;
    }

}
