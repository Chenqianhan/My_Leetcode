package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class OneZeroFour_MaximumDepthOfBinaryTree {
    //To find the deepest leaf, dfs seems a good choice.
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
