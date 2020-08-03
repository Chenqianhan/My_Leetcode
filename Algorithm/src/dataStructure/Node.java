package dataStructure;

import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
        left = null;
        right = null;
        next = null;
        random=null;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }


}
