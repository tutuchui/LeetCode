package graduate;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows;i++){
            result.add(new ArrayList<>());
            for(int j = 0; j <= i;j++){
                regressionGenerate(i,j,result);
            }
        }
        return result;
    }

    public void regressionGenerate(int i,int j, List<List<Integer>> result){
        if(j == 0 || j == i){
            result.get(i).add(j,1);
        }else{
            int tmp = result.get(i-1).get(j-1) + result.get(i-1).get(j);
            result.get(i).add(j,tmp);
        }
    }


}
