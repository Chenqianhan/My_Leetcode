package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.LinkedList;

public class NinetyEight_ValidateBST {
    //Unexpected case: There are duplicated number in trees, which BST doesn't have.
    //List<Integer> list = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();
    //List<Integer> list = new LinkedList<>(); //If type is List, there is no poll();
    public boolean isValidBST(TreeNode root) {
        traverseInorder(root);
        /*
        for(int i=1;i<list.size();i++){
            if(list.get(i-1)>=list.get(i))
                return false;
        }
        */

        //Actually LinkedList performs same as ArrayList here.
        while(list.size()>1){
            int cur = list.poll();
            if(cur>=list.peek())
                return false;
        }

        return true;
    }

    public void traverseInorder(TreeNode root){
        if(root==null)
            return;

        traverseInorder(root.left);
        list.add(root.val);
        traverseInorder(root.right);
    }
}
