package solutions;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AHundredAndThree_ZigzagTree {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result=new ArrayList<>();
            zigzag(root,0,result);
            return result;
        }

        private void zigzag(TreeNode root, int level, List<List<Integer>> result){
            if(root==null) return;
            if(result.size()<=level) result.add(new ArrayList<>());

            if(level%2==0){
                result.get(level).add(root.val);
            }else{
                result.get(level).add(0,root.val);
            }

            zigzag(root.left, level+1, result);
            zigzag(root.right, level+1, result);
        }
    }

