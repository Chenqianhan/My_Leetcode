package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class FiveSeventyTwo_SubtreeOfAnotherTree {
    //In this way we can avoid full recursion.
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;

        if(s.val==t.val)
            if(isEqual(s,t))
                return true;

        if(isSubtree(s.left,t))
            return true;

        return isSubtree(s.right,t);
    }

    public boolean isEqual(TreeNode x, TreeNode y){
        if(x==null && y==null) return true;
        if(x==null || y==null) return false;

        return x.val==y.val && isEqual(x.left,y.left) && isEqual(x.right,y.right);
    }
}
