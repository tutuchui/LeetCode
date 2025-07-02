package classisc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while(!levelQueue.isEmpty()) {
            double sum = 0;
            int size = levelQueue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = levelQueue.poll();
                sum += node.val;
                if(node.left != null) {
                    levelQueue.add(node.left);
                }
                if(node.right != null) {
                    levelQueue.add(node.right);
                }
            }
            list.add(sum/size);
        }
        return list;
    }
}
