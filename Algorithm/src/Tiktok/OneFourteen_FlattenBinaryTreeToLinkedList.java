package Tiktok;

import dataStructure.TreeNode;

public class OneFourteen_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        helper(root, null);
    }

    public TreeNode helper(TreeNode root, TreeNode last){
        if(root == null) return last;

        root.right = helper(root.left, helper(root.right, last));
        root.left = null;

        return root;
    }
}
