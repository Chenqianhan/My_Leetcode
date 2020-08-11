package topologyAndQueue;

import java.util.*;

public class TwoSixtyNine_AlienDictionary {
    public String alienOrder(String[] words) {
        //Create data structure.
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for(String word:words){
            for(char c:word.toCharArray()){
                graph.putIfAbsent(c,new ArrayList<>());
                indegree.putIfAbsent(c,0);
            }
        }
        //Build graph;
        for(int i=1;i<words.length;i++){
            String word1 = words[i-1];
            String word2 = words[i];
            if(word1.length()>word2.length()&&word1.startsWith(word2)) return "";
            int len = Math.min(word1.length(),word2.length());
            for(int j = 0;j<len;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1!=c2){
                    graph.get(c1).add(c2);
                    indegree.put(c2,indegree.get(c2)+1);
                    //indegree.put(c2,indegree.get(c2)++); //idk why it cause error.
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : indegree.keySet()){
            if(indegree.get(c)==0) queue.add(c);
        }

        while(!queue.isEmpty()){
            Character c = queue.poll();
            sb.append(c);
            for(Character nxt:graph.get(c)){
                indegree.put(nxt, indegree.get(nxt)-1);
                if(indegree.get(nxt)==0){
                    queue.add(nxt);
                }
            }
        }
        if(sb.length()<indegree.size()) return "";

        return sb.toString();
    }
}
