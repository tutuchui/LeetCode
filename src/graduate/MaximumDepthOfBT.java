package graduate;

//Leetcode 104
public class MaximumDepthOfBT {
    public int maxDepth(TreeNode root) {
        TreeNode cur = root;
        if(cur == null){
            return 0;
        }
        return findDepth(root,1);

    }

    public int findDepth(TreeNode node, int depth){
        int left = depth;
        int right = depth;
        if(node.left != null){
            TreeNode next_node = node.left;
            left =  findDepth(next_node, depth + 1);
        }
        if(node.right != null){
            TreeNode next_node = node.right;
            right = findDepth(next_node, depth + 1);
        }
        if(node.left == null && node.right == null){
            return depth;
        }

        return Math.max(left,right);
    }
}
