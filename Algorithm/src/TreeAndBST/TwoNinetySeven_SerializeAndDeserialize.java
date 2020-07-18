package TreeAndBST;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TwoNinetySeven_SerializeAndDeserialize {
    // Encodes a tree to a single string.
    //Two special cases: null and negative value. It is noted that if not defined, val = 0;
    //Mistake: 1. String should use equals() but not ==;
    //2. There must be a spacer, or we cannot recognize negative or numbers > 9;
    //3. str="1,2,3,,,4,5,,," -> str.split(",")={"1","2","3","","","4","5"};
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        q.offer(root);
        TreeNode temp;
        while(!q.isEmpty()){
             temp = q.poll();
            if(temp.left!=null){
                q.offer(temp.left);
                sb.append(",").append(String.valueOf(temp.left.val));
            }else{
                sb.append(",");
            }

            if(temp.right!=null){
                q.offer(temp.right);
                sb.append(",").append(String.valueOf(temp.right.val));
            }else{
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

        for(int i=1;i<values.length;i++){
            TreeNode temp = q.poll();
            if(!values[i].equals("")){
                temp.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(temp.left);
            }

            if(++i<values.length){
                if(!values[i].equals("")){
                    temp.right = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(temp.right);
                }
            }
        }
        return root;
    }

    /*
    //It is strange that the one above works well but this fail in NullPointerException.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] strs = data.split(",");

        int n = Integer.parseInt(strs[0]);
        TreeNode root = new TreeNode(n);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        TreeNode temp = root;
        while(i<strs.length){
            temp = q.poll();

            if(!strs[i].equals("")){
                //assert temp != null;
                temp.left = new TreeNode(Integer.parseInt(strs[i]));
                q.offer(temp.left);
            }
            i++;

            if(i<strs.length){
                if(!strs[i].equals("")){
                    temp.left = new TreeNode(Integer.parseInt(strs[i]));
                    q.offer(temp.right);
                }
                i++;
            }
        }
        return root;
    }
    */
}
