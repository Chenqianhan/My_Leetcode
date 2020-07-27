package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class TwoThirtyFive_LowestCommonAncestorOfBST {
    //Two important thing: 1. This is a BST; 2. A node's ancestor can be itself.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val, qVal = q.val;

        if(pVal>parentVal && qVal>parentVal){
            return lowestCommonAncestor(root.right, p, q);
        }else if(pVal<parentVal && qVal<parentVal){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
}
