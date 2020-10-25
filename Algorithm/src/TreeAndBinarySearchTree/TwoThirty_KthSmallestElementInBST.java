package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoThirty_KthSmallestElementInBST {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return list.get(k-1); //Because k begin at 1 while index begin at 0;
    }

    public void traverse(TreeNode root){
        if(root==null) return;

        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

}
