package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NinetyFour_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //ArrayList is using less memory than LinkedList, 37.3MB(94.7%) to 39.9MB(7%)
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list){
        if(root==null)
            return;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
