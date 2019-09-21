import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null){
            return output;
        }
        inorderTra(root,output);
        return output;
    }

    public void inorderTra(TreeNode node, List<Integer> output){
        if(node.left != null){
            inorderTra(node.left,output);
        }
        output.add(node.val);
        if(node.right != null){
            inorderTra(node.right,output);
        }
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        if(root == null){
            return output;
        }
        TreeNode cur = root;
        while(cur!=null ||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            output.add(cur.val);
            cur = cur.right;

        }
        return output;
    }
}
