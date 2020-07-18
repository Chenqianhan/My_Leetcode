package TreeAndBST;

import dataStructure.TreeNode;

public class FiveFortyThree_DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode node){
        if(node==null)
            return 0;

        int LD = maxDepth(node.left);
        int RD = maxDepth(node.right);
        max = Math.max(max, LD+RD);
        return 1+Math.max(LD,RD);
    }
}
