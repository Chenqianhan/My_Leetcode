package dataStructure;

public class TwoZeroEight_Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public TwoZeroEight_Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    //Below two methods' common operations can be isolated as a method searchPrefix.
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)) return false;
            node = node.get(c);
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!node.containsKey(c)) return false;
            node = node.get(c);
        }
        return node!=null;
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){ links = new TrieNode[R]; }

    public boolean containsKey(char c){ return links[c-'a']!=null; }

    public TrieNode get(char c){ return links[c-'a']; }

    public void put(char c, TrieNode node){ links[c-'a']=node; }

    public void setEnd(){ isEnd = true; }

    public boolean isEnd(){ return isEnd; }
}
