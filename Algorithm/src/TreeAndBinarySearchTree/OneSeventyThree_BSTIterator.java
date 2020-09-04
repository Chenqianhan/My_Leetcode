package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.LinkedList;

public class OneSeventyThree_BSTIterator {
    //Type of List cannot use operations of pop()=poll(), push(), add();
    LinkedList<Integer> list;
    public OneSeventyThree_BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        traverse(root);
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext()) return list.removeFirst();
        else return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list.size()>0;
    }

    //Inorder
    public void traverse(TreeNode node){
        if(node==null) return;

        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }
}
