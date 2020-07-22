package Graph;
import java.util.HashMap;

public class OneThirtyThree_CloneGraph {
    //Declare a variable must be outside a if-else block;
    //DFS
    private HashMap<Node,Node> map = new HashMap<>();;

    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        return dfs(node);

    }

    public Node dfs(Node node){
        if(map.containsKey(node))
            return map.get(node);

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor: node.neighbors){
            newNode.neighbors.add(dfs(neighbor));
        }

        return newNode;
    }

    /*
    //BFS
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;

        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node,new Node(node.val));

        while(!queue.isEmpty()){
            //Node n = queue.poll();
            Node n = queue.remove();

            for(Node neighbor: n.neighbors){
                if(!map.containsKey(neighbor)){
                    queue.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    */
}
