package DFSandRecursion;

import java.util.ArrayList;
import java.util.List;
//Hardest problem in DFS.
public class TwoTwelve_wordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, res, root, i, j);
            }
        }
        return res;
    }

    public void dfs(char[][] board, List<String> res, TrieNode p, int i, int j){
        char c = board[i][j];
        if(c == '*' || p.next[c - 'a']==null) return;
        p = p.next[c - 'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word = null; //Avoid duplicate.
        }

        board[i][j] = '*';
        if(i>0) dfs(board, res, p, i-1, j);
        if(i<board.length-1) dfs(board, res, p, i+1, j);
        if(j>0) dfs(board, res, p, i, j-1);
        if(j<board[0].length-1) dfs(board, res, p, i, j+1);
        board[i][j] = c;

    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s:words){
            TrieNode p = root;
            for(char c:s.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = s;
        }

        return root;
    }

    public class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
