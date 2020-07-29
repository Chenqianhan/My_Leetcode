package TreeAndBinarySearchTree;

import dataStructure.Node;
import java.util.ArrayList;
import java.util.Stack;

/**
 * A bull-shit problem: I have struggled for NullPointerException from nowhere.
 * Then I found that this problem requires each node to have a children list even it is empty.
 */
public class FourTwentyEight_SerializeAndDeserializeNTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null)
            return null;

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sHelper(root, sb);
        return sb.toString();
    }

    public void sHelper(Node root, StringBuilder sb){
        if(root.children==null || root.children.size()<1)
            return;
        sb.append(" ").append("[");
        for(Node node:root.children){
            sb.append(" ").append(node.val);
            sHelper(node, sb);
        }
        sb.append(" ").append("]");
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data==null)
            return null;

        String[] values = data.split(" ");
        Stack<Node> stack = new Stack<>();
        //Node root = new Node(Integer.parseInt(values[0]));
        Node root = new Node(Integer.parseInt(values[0]),new ArrayList<>());
        Node lastNode = root;

        for(int i=1;i<values.length;i++){
            if(values[i].equals("[")){
                stack.push(lastNode);
            }else if(values[i].equals("]")){
                stack.pop();
            }else{
                lastNode = new Node(Integer.parseInt(values[i]),new ArrayList<>());
                stack.peek().children.add(lastNode);
            }

        }

        return root;
    }

}
