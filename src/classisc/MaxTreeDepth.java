package classisc;

public class MaxTreeDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = 0, rightDepth = 0;
        if(root.left != null) {
             leftDepth = maxDepth(root.left) + 1;
        }
        if(root.right != null) {
             rightDepth = maxDepth(root.right) + 1;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
