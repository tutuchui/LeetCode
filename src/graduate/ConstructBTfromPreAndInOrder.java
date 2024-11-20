package graduate;

//leetcode 105
public class ConstructBTfromPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode curRoot = new TreeNode(preorder[0]);
        int leftCount = 0;
        while(inorder[leftCount]!=preorder[0]){
            leftCount++;
        }
        int[] leftInorder = new int[leftCount];
        int[] leftPreorder = new int[leftCount];
        for(int i = 0; i < leftCount; i++){
            leftInorder[i] = inorder[i];
            leftPreorder[i] = preorder[i + 1];
        }
        curRoot.left = buildTree(leftPreorder,leftInorder);
        int rightCount = preorder.length - leftCount - 1;
        int[] rightInorder = new int[rightCount];
        int[] rightPreorder = new int[rightCount];
        for(int i = 0; i < rightCount; i++){
            rightInorder[i] = inorder[leftCount + 1 + i];
            rightPreorder[i] = preorder[leftCount + 1 + i];
        }
        curRoot.right = buildTree(rightPreorder,rightInorder);
        return curRoot;
    }
}
