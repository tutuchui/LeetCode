package classisc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RightViewTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Stack<Integer>> treeNode = new ArrayList<>();
        recordAllTreeNode(root, treeNode, 0);
        for(Stack<Integer> curLevelTreeNode : treeNode) {
           list.add(curLevelTreeNode.pop());
        }

        return list;

    }

    public void recordAllTreeNode(TreeNode root, List<Stack<Integer>> treeNode, int depth) {
        if(treeNode.size() <= depth) {
            treeNode.add(new Stack<>());
        }
        treeNode.get(depth).add(root.val);
        if(root.left != null) {
            recordAllTreeNode(root.left, treeNode, depth + 1);
        }
        if(root.right != null) {
            recordAllTreeNode(root.right, treeNode, depth + 1);
        }
    }
}
