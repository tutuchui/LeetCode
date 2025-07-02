package classisc;

public class RootToNodeSum {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sumNumbers(root, root.val);
    }

    public int sumNumbers(TreeNode root, int curVal) {
        if(root.left == null && root.right == null) {
            return curVal;
        }
        int sum = 0;
        if(root.left != null) {
            sum += sumNumbers(root.left, curVal * 10 + root.left.val);
        }
        if(root.right != null) {
            sum += sumNumbers(root.right, curVal * 10 + root.right.val);
        }
        return sum;
    }
}
