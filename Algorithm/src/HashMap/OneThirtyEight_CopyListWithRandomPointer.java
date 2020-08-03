package HashMap;

import dataStructure.Node;

import java.util.HashMap;

public class OneThirtyEight_CopyListWithRandomPointer {
    //Val is not distinct.
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();

        Node dummy = head;
        while(dummy!=null){
            map.put(dummy,new Node(dummy.val));
            dummy = dummy.next;
        }

        for(Node prev:map.keySet()){
            Node nxt = map.get(prev);
            nxt.next = map.get(prev.next);
            nxt.random = map.get(prev.random);
        }

        return map.get(head);
    }
}
