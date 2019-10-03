package NewOffer;

public class NewOffer4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
       if(pre.length == 0){
           return null;
       }
       TreeNode root = new TreeNode(pre[0]);
       int index = -1;
       for(int i = 0; i < in.length; i++){
           if(in[i] == pre[0]){
               index = i;
           }
       }
       int[] leftPre = new int[index];
       int[] leftIn = new int[index];
       for(int i = 0; i < index; i++){
           leftPre[i] = pre[i+1];
           leftIn[i] = in[i];
       }
        root.left = reConstructBinaryTree(leftPre,leftIn);
        int[] rightPre = new int[pre.length - index - 1];
        int[] rightIn = new int[pre.length - index - 1];
        for(int i = 0; i < rightPre.length; i++){
            rightPre[i] = pre[i+1+index];
            rightIn[i] = in[index+i+1];
        }
        root.right = reConstructBinaryTree(rightPre,rightIn);
        return root;
    }
}
