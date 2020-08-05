package DFSandBFS;

import java.util.*;

public class OneTwentySeven_WordLadder {
    //A* maybe way faster. Just look at it latter.
    //BFS is most straightforward approach.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size(), cnt=1, letterLen = beginWord.length();
        HashMap<String, List<String>> map = new HashMap<>();
        //Build graph
        for(int i = 0;i<len;i++){
            String a = wordList.get(i);
            List<String> list = new ArrayList<>();
            map.put(a, list);
            for(int j = 0;j<len;j++){
                if(i==j) continue;
                String b =wordList.get(j);
                if(isTransformable(letterLen, a, b)){
                    list.add(b);
                }
            }
        }

        List<String> tmp = new ArrayList<>();
        map.put(beginWord, tmp);
        for (String b : wordList) {
            if (isTransformable(letterLen, beginWord, b))
                tmp.add(b);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> isVisited = new HashSet<>();

        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            while(size>0){
                List<String> list = map.getOrDefault(queue.poll(), new ArrayList<>());
                for(String nxt:list){
                    if(isVisited.contains(nxt)) continue;

                    if(nxt.equals(endWord)) return cnt;
                    queue.offer(nxt);
                    isVisited.add(nxt);
                }
                size--;
            }
        }

        return 0;
    }

    public boolean isTransformable(int len, String a, String b){
        int similarity = 0;
        for(int i = 0; i < len; i++){
            if(a.charAt(i)!=b.charAt(i))
                similarity++;
        }
        return similarity==1;
    }
}
