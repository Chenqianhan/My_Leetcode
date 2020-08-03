package DFSandBFS;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OneZeroTwo_BinaryTreeLevelOrderTraversal {
    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                size--;
            }
            res.add(tmp);
        }

        return res;
    }
}
