package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

public class OneEleven_MinimumDepthOfBinaryTree {
    //Both implementations perform equally.
    //Recursion
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        int minDepth = Integer.MAX_VALUE;
        if(root.left!=null)
            minDepth = Math.min(minDepth,minDepth(root.left));

        if(root.right!=null)
            minDepth = Math.min(minDepth,minDepth(root.right));

        return minDepth+1;
    }
    /*
    //BFS
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        loop: while(!queue.isEmpty()){
            minDepth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left==null && node.right==null)
                    return minDepth;

                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                    queue.offer(node.right);

            }
        }
        return minDepth;
    }
    */
}
