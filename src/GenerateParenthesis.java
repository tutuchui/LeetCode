import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        addBracket(result,"",0,0,n);
        return result;
    }

    public void addBracket(List<String> result, String cur, int open, int close, int n){
        if(cur.length() == 2 * n){
            result.add(cur);
            return;
        }

        if(open < n){
            addBracket(result,cur + "(",open + 1,close,n);
        }
        if(close < open){
            addBracket(result,cur + ")",open,close + 1,n);
        }
    }
}
