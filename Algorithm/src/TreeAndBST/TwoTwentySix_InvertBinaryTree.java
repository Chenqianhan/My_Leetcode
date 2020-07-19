package TreeAndBST;

import dataStructure.TreeNode;

public class TwoTwentySix_InvertBinaryTree {
    //The problem is nullPointerException.
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
