package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class OneTwentyFour_BinaryTreeMaximumPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        helper(root);

        return max;
    }

    public int helper(TreeNode node){
        if(node==null) return 0;

        int left = helper(node.left), right = helper(node.right), cur = node.val;
        if(left>0 && right>0){
            max = Math.max(max, left+right+cur);
            return left>right?cur+left:cur+right;
        }else if(left>0){
            max = Math.max(max,left+cur);
            return left+cur;
        }else if(right>0){
            max = Math.max(max,right+cur);
            return right+cur;
        }else{
            max = Math.max(max,cur);
            return cur;
        }
    }
}
