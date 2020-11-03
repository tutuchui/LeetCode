import java.util.ArrayList;

class Solution {

    public ArrayList<ArrayList<Integer>> findTargetPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curPath = new ArrayList<>();
        if (root != null) {
            dfs(root, res, curPath, target, 0);
        }
        return res;
    }

    public void dfs(TreeNode curNode, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curPath, int target, int curSum) {

        curPath.add(curNode.val);
        curSum += curNode.val;
        if (curSum == target) {
            res.add(curPath);
        }
        if (curNode.left != null) {
            dfs(curNode.left, res, new ArrayList<>(curPath), target, curSum);
        }
        if (curNode.right != null) {
            dfs(curNode.right, res, new ArrayList<>(curPath), target, curSum);
        }
        if (curPath.size() == 2) {
            dfs(curNode, res, new ArrayList<>(), target, 0);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t6 = new TreeNode(13);
        TreeNode t7 = new TreeNode(4);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(3);
        TreeNode t14 = new TreeNode(9);
        TreeNode t15 = new TreeNode(5);
        TreeNode t16 = new TreeNode(8);
        TreeNode t18 = new TreeNode(6);
        TreeNode t19 = new TreeNode(10);
        TreeNode t28 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t7.left = t14;
        t7.right = t15;
        t8.left = t16;
        t9.left = t18;
        t9.right = t19;
        t14.left = t28;

        System.out.println(new Solution().findTargetPath(t1,9));
    }

}
