package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class OneZeroFive_ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        //Ending condition.
        if(preStart>preorder.length || inStart>inEnd)
            return null;

        //Root is the preStart of preorder.
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        //Then find out root's index in inorder to tell the left side and right side.
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]== root.val){
                inIndex = i;
                break;
            }
        }

        root.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
        //inIndex-inStart is the number of left subtrees.
        root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);

        return root;
    }
}
