package graduate;

import java.util.ArrayList;
import java.util.List;

//Leetcode 1104
public class ZigZagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        result.add(label);
        if(label == 1){
            return result;
        }
        while(findParentNode(label) != 1){
            int parentNode = findParentNode(label);
            result.add(0,parentNode);
            label = parentNode;
        }
        result.add(0,1);
        return result;
    }

    public int findParentNode(int label){
        int originalParentNode = label / 2;
        int layer = findLayer(originalParentNode);
        if(layer == 1){
            return 1;
        }else{
            int curSum =(int)(3 * Math.pow(2, layer - 1) - 1);
            return curSum - originalParentNode;
        }
    }

    public int findLayer(int label) {
        return (int)(Math.log(label) / Math.log(2)) + 1;
    }


}
