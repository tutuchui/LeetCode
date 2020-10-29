public class TreeCommonAncestor {
    private TreeNode ans;
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q){
        if(currentNode == null){
            return false;
        }

        int left = recurseTree(currentNode.left,p,q) ? 1 : 0;
        int right = recurseTree(currentNode.right,p,q) ? 1 : 0;
        int mid = (currentNode.val == p.val || currentNode.val == q.val) ? 1 : 0;

        if(left + right + mid >= 2){
            ans = currentNode;
        }

        return (left + right + mid) > 0;
    }
}
