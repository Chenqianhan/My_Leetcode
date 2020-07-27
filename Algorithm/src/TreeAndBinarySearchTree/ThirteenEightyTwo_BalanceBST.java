package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ThirteenEightyTwo_BalanceBST {
    //Core idea; Deconstruct the tree then reconstruct it.
    //Cuz modification based on given tree is complicated.
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        deconstruct(root);
        if(list.size()==0)
            return null;
        return construct(0,list.size()-1);
    }

    public void deconstruct(TreeNode root){
        if(root==null)
            return;

        //Inorder recursion, which guarantee list is in ascending order.
        deconstruct(root.left);
        list.add(root);
        deconstruct(root.right);
        root.left=null;
        root.right=null;
    }

    public TreeNode construct(int left, int right){
        if(left>right)
            return null;

        int mid = right - (right-left)/2;
        TreeNode root = list.get(mid);
        root.left = construct(left, mid-1);
        root.right = construct(mid+1,right);

        return root;
    }

    public ThirteenEightyTwo_BalanceBST() {
    }
}
