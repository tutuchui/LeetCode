package graduate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    //regression

    public List<Integer> preorderTraversalReg(TreeNode root) {
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
        if(node.right!= null){
            preorder(node.right,list);
        }
    }

    //Iteration
    public List<Integer> preorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null){
            return output;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            output.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return output;
    }
}
