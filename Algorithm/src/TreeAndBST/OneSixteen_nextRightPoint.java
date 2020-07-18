package TreeAndBST;

import dataStructure.Node;

//Note: for those data structures such as node and treenode, we cannot assign null value to node, which cause nullPointerException.
//i.e. node.next, if it is null, doing nothing rather than assigning null.
public class OneSixteen_nextRightPoint {
        /*
    //Iterative
    public Node connect(Node root) {
        if(root==null)
            return root;
        Node pointer = root;
        while(pointer.left!=null){
            Node subPointer = pointer;
            while(subPointer!=null){
                subPointer.left.next = subPointer.right;
                if(subPointer.next!=null) subPointer.right.next = subPointer.next.left;
                subPointer=subPointer.next;
            }
            pointer=pointer.left;
        }
        return root;
    }
    */

    //Recursive
    public Node connect(Node root) {
        if(root==null)
            return root;
        if(root.left!=null)
            traverseLevel(root);
        return root;
    }

    public void traverseLevel(Node node){
        Node temp = node;
        while(temp!=null){
            temp.left.next = temp.right;
            if(temp.next!=null)
                temp.right.next = temp.next.left;
            temp = temp.next;
        }
        if(node.left.left!=null)
            traverseLevel(node.left);
    }
}
