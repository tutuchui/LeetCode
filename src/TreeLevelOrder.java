import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        LinkedList<Integer> valueList = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node!=null){
                valueList.addLast(node.val);
                queue2.addLast(node.left);
                queue2.addLast(node.right);
            }
            if(queue.isEmpty() && !valueList.isEmpty()){
                result.add(valueList);
                valueList = new LinkedList<>();
                queue = queue2;
                queue2 = new LinkedList<>();
            }
        }

        return result;

    }
}
