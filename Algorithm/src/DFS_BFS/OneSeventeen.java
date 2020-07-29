package DFS_BFS;

import dataStructure.Node;

import java.util.LinkedList;
import java.util.Queue;

public class OneSeventeen {
    public Node connect(Node root){
        if(root==null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node node;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size-1;i++){
                node = queue.poll();
                node.next = queue.peek();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            node = queue.poll();
            node.next = null;
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

        return root;
    }
    /*
    private HashMap<Integer, List<Node>> map = new HashMap<>();
    public Node connect(Node root) {
        constructor(root,0);
        for(int i:map.keySet()){
            List<Node> list = map.get(i);
            for(int j=0;j<list.size()-1;j++){
                list.get(j).next = list.get(j+1);
            }
            list.get(list.size()-1).next = null;
        }
        return root;
    }

    public void constructor(Node root, int level){
        if(root==null)
            return;

        constructor(root.left, level-1);
        List<Node> list = map.getOrDefault(level,new ArrayList<>());
        list.add(root);
        map.put(level, list);
        constructor(root.right, level-1);
    }
    */
}
