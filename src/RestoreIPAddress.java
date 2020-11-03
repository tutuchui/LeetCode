import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return result;
        }
        dfs(s,s.length(),0,4,new LinkedList<>(), result);
        return result;
    }

    public void dfs(String s, int len, int begin, int remainSeg, LinkedList<String> path, List<String> result){
        if(begin == len){
            if(remainSeg == 0){
                result.add(String.join(".",path));
            }
        }

        for(int i = begin; i < begin + 3; i++){
            if(i >= len){
                break;
            }
            if(len - i  > remainSeg * 3){
                continue;
            }

            if(isValidIPSegment(s, begin, i + 1)){
                String curSeg = s.substring(begin, i + 1);
                path.add(curSeg);
                dfs(s,len,i + 1, remainSeg - 1, path, result);
                path.removeLast();
            }
        }

    }

    private boolean isValidIPSegment(String s, int start, int end){
        int len = end - start;
        if(len > 1 && s.charAt(start) == '0'){
            return false;
        }

        String seg = s.substring(start,end);

        return Integer.parseInt(seg) >= 0 && Integer.parseInt(seg) <= 255;
    }
}
