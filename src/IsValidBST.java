import java.util.LinkedList;

//leetcode 98
//使用中序遍历，判断当前遍历的数 是否小于前一个数，不满足则直接返回false
public class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
