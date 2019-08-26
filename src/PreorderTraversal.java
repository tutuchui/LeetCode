import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode node,List list){
        list.add(node.val);
        if(node.left == null && node.right == null){
            return ;
        }
        if(node.left != null ){
            preorder(node.left,list);
        }
        if(node.right != null);
        {
            preorder(node.right,list);
        }
    }
}
