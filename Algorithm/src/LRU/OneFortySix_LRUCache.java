package LRU;

import java.util.HashMap;

public class OneFortySix_LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    final Node head = new Node();
    final Node tail = new Node();

    public OneFortySix_LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.size()==0 || !map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        //First identify if it's a existing key; Second, if it is full.
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        }else{
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node();
            node.val = value;
            node.key = key;
            map.put(key, node);
            add(node);
        }
    }

    public void add(Node node){
        Node node_next = head.next;
        head.next = node;
        node.prev = head;

        node.next = node_next;
        node_next.prev = node;
    }

    public void remove(Node node){
        Node node_prev = node.prev;
        Node node_next = node.next;

        node_prev.next = node_next;
        node_next.prev = node_prev;
    }

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}
