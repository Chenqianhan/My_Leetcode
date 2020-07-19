package TreeAndBST;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElevenTen_DeleteNodesAndReturnForest {
    //Using bit operation fails to recognize elements. That's weird.
    private List<TreeNode> list;
    private Set<Integer> set;
    //private int isDelete;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list = new ArrayList<>();
        set = new HashSet<>();
        for(int i:to_delete)
            set.add(i);

        helper(root,root,false);
        return list;
    }

    public void helper(TreeNode lastRoot, TreeNode index, boolean isLeft){
        if(index==null)
            return;

        if(index.equals(lastRoot) && !set.contains(index.val))
            list.add(index);

        if(set.contains(index.val)){
            helper(index.left,index.left,true);
            helper(index.right,index.right,false);
            if(isLeft){
                lastRoot.left=null;
            }else{
                lastRoot.right=null;
            }
        }else{
            helper(index,index.left,true);
            helper(index,index.right,false);
        }

    }
}
