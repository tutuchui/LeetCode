package graduate;

import java.util.LinkedList;

public class IsSymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node!=null) {
                queue2.addLast(node.left);
                queue2.addLast(node.right);
            }
            if(queue.isEmpty()){
                if(isNullList(queue2)){
                    break;
                }
                if(!isSymmetricList(queue2)){
                    return false;
                }
                queue = queue2;
                queue2 = new LinkedList<>();
            }

        }
        return true;

    }

    public boolean isSymmetricList(LinkedList<TreeNode> list){
        for(int i = 0; i < list.size()/2;i++){
            if(!nodeCompare(list.get(i),list.get(list.size()-1-i))){
                return false;
            }
        }
        return true;
    }

    public boolean isNullList(LinkedList<TreeNode> list){
        for(TreeNode tmp : list){
            if(tmp!=null){
                return false;
            }
        }
        return true;
    }

    public boolean nodeCompare(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1!=null && node2!=null && node1.val == node2.val){
            return true;
        }else{
            return false;
        }
    }
}
