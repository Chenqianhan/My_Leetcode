package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NineNinetyThree_CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            boolean siblings = false, cousins = false;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur==null){
                    siblings = false;
                }else{
                    if(cur.val==x||cur.val==y){
                        if(!cousins){
                            siblings = cousins = true;
                        }else{
                            return !siblings;
                        }
                    }
                    if(cur.right!=null) queue.offer(cur.right);
                    if(cur.left!=null) queue.offer(cur.left);

                    queue.offer(null);
                }
            }
            if(cousins) return false;
        }
        return false;
    }

}
