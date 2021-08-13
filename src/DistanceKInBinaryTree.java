import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceKInBinaryTree {

    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null){
            return null;
        }
        findParents(root);
        findAns(target, null, 0,k);
        return result;
    }

    public void findParents(TreeNode node){
        if(node.left != null){
            parents.put(node.left.val, node);
            findParents(node.left);
        }

        if(node.right != null){
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode curNode, TreeNode from, int depth, int k){
        if(curNode == null){
            return;
        }
        if(depth == k){
            result.add(curNode.val);
        }
        if(curNode.left != from){
            findAns(curNode.left, curNode, depth + 1, k);
        }
        if(curNode.right != from){
            findAns(curNode.right, curNode, depth + 1, k);
        }
        if(parents.containsKey(curNode.val) && parents.get(curNode.val) != from){
            findAns(parents.get(curNode.val),curNode, depth + 1, k);
        }
    }



}
