package classisc;

public class TreePathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, 0, sum);
    }

    public boolean hasPathSum(TreeNode treeNode, int curSum, int sum) {
        curSum += treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            return curSum == sum;
        }
        if (treeNode.left != null && treeNode.right != null) {
            return hasPathSum(treeNode.right, curSum, sum) ||
                    hasPathSum(treeNode.left, curSum, sum);
        } else if (treeNode.right != null) {
            return hasPathSum(treeNode.right, curSum, sum);
        }else {
            return hasPathSum(treeNode.left, curSum, sum);
        }
    }

    public static void main(String[] args) {
        TreePathSum treePathSum = new TreePathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(treePathSum.hasPathSum(root, 1));
    }
}
