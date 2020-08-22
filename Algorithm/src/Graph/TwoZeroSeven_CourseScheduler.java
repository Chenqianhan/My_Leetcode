package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TwoZeroSeven_CourseScheduler {
    //88.5%, 81%. BFS. Using degree to identify loop.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Remember, here the ArrayList's element type is Object, Cuz it isn't parameterized.
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<>();

        for(int[] pre:prerequisites){
            //This is inDegree.
            degree[pre[1]]++;
            graph[pre[0]].add(pre[1]);
        }

        for(int i=0; i< numCourses; i++){
            if(degree[i]==0){
                //Start from end.
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            for(Object o:graph[course]){
                int pre = (int)o;
                degree[pre]--;
                //Only deal with clean point
                if(degree[pre]==0){
                    queue.add(pre);
                    count++;
                }
            }
        }

        return count==numCourses;
    }
}

/*
//BackTracking + DFS, not that efficient.
class Solution {
    //Cannot use map cuz there could be multiple prerequisites.
    //Core idea: DFS+backtracking.
    private HashMap<Integer,List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1)
            return true;

        for(int[] i: prerequisites){
            List<Integer> list = map.getOrDefault(i[0],new ArrayList<>());
            list.add(i[1]);
            map.put(i[0], list);
        }

        for(int i: map.keySet()){
            //List<Integer> list = new ArrayList<>(numCourses);
            //list.add(i);
            if(isCircular(i, new boolean[numCourses]))
            //if(isCircular(i, list))
                return false;
        }
        return true;
    }
    //5%,5%; Comparing to List, boolean array at least works though performs not that good.
    public boolean isCircular(int key, boolean[] visited){
        if(map.containsKey(key)){
            for(int value:map.get(key)){
                if(visited[value]){
                    return true;
                }else{
                    visited[value]=true;
                    if(isCircular(value,visited))
                        return true;
                    visited[value]=false;
                }
            }
        }
        return false;
    }
*/

//Below are wrong try.
    /*
    //Cannot deal with a great deal of numbers.
    public boolean isCircular(int key, List<Integer> visited){
        if(map.containsKey(key)){
            for(int value:map.get(key)){
                if(visited.contains(value)){
                    return true;
                }else{
                    visited.add(value);
                    if(isCircular(value,visited))
                        return true;
                    visited.remove(visited.size()-1);
                }
            }
        }
        return false;
    }
    */

    /*
    //Bit operation cannot deal with integer > 32.
    public boolean isCircular(int key, int visited){
        //visited |= 1<<key;
        if((visited & 1<<key)>0){
            return true;
        }else{
            if(map.containsKey(key)){
                visited |= 1<<key;
                for(int value:map.get(key))
                    if(isCircular(value, visited))
                        return true;
            }

            return false;
        }
        */

        /*
        //boolean flag = false;
        if(map.containsKey(key)){
            for(int value:map.get(key)){
                //Problem: [[2,0],[1,0],[3,1],[3,2],[1,3]], when visited comes to [3,1,0], then 0 return false;
                //Solution: using flag rather than return true/false;
                //Problem: When I use ArrayList to record isVisited, it failed when comes to [[0,1],[0,2],[1,2]]
                //Solution: bit operation on integer, in each path of dfs, visited are different.
                //Problem: Time limit Exceeded, it is trapped in the loop.
                if((visited & 1<<value)==1){
                    //flag = true;
                    return true;
                    //break;
                }else{
                    //visited |= 1<<value;
                    //flag |= isCircular(value, visited | 1<<value);
                    return isCircular(value, visited | 1<<value);
                }
            }
        }

        //return flag;
        return false;

    }
        */