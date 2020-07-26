package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.Stack;

public class OneTwelve_PathSum {
    //Solution 2 preorder DFS: 2ms, 39.8MB
    //I assumed DFS performs better intuitively but actually sucks.
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum-root.val);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int count = sums.pop();
            if(node.left==null && node.right==null && count==0)
                return true;

            if(node.right!=null){
                stack.push(node.right);
                sums.push(count-node.right.val);
            }

            if(node.left!=null){
                stack.push(node.left);
                sums.push(count-node.left.val);
            }

        }
        return false;
    }
    /*
    //Solution 1.1 Brute Force: 0ms, 39.4MB
    //Code-Refine version for below.
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;

        sum -=root.val;
        if(root.left==null && root.right==null)
            return sum==0;

        //In this situation, there is no difference between '|' and '||'.
        return hasPathSum(root.left, sum)||hasPathSum(root.right, sum);

    }
    */

    /*
    //Solution 1 Brute Force: 1ms, 41.1MB
    private int SUM;
    public boolean hasPathSum(TreeNode root, int sum) {
        SUM = sum;
        return helper(root, 0);
    }

    public boolean helper(TreeNode root, int sum){
        if(root==null)
            return false;

        int s = sum + root.val;
        if(root.left==null && root.right==null){
            if(s==SUM)
                return true;
            else{
                return false;
            }
        }

        return helper(root.left, s)|helper(root.right, s);
    }
    */
}
