package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class OneFortyFour_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list){
        if(root==null)
            return;

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}
