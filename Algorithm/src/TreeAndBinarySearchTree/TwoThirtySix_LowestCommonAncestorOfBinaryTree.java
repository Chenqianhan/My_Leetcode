package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class TwoThirtySix_LowestCommonAncestorOfBinaryTree {
    //Inituitive way
    TreeNode res = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return 0;

        int flag = 0;
        if(root.val==p.val || root.val==q.val)
            flag++;

        flag+=helper(root.left,p,q)+helper(root.right,p,q);
        if(flag==2){
            res = root;
            return 0;
        }else{
            return flag;
        }
    }
}
