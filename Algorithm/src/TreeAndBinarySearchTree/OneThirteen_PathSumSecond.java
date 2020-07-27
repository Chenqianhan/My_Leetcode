package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OneThirteen_PathSumSecond {
    //One-time pass. 1ms(99.89%),39.9MB(48%)
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return res;

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        helper(root, sum-root.val, list);
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> list){
        if(root==null)
            return;

        if(root.left==null && root.right==null && sum==0)
            //When using List in recursion.
            res.add(new ArrayList<>(list));

        if(root.left!=null){
            list.add(root.left.val);
            helper(root.left, sum-root.left.val, list);
            list.remove(list.size()-1);
        }

        if(root.right!=null){
            list.add(root.right.val);
            helper(root.right, sum-root.right.val, list);
            list.remove(list.size()-1);
        }
    }


}
