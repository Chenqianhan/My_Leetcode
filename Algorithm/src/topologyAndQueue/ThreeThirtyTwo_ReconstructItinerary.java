package topologyAndQueue;

import java.util.*;

public class ThreeThirtyTwo_ReconstructItinerary {
    /*
     *DFS+Backtracking.
     *Step 1: Build a graph data structure from the given input.
     *        We adopt the hashmap with each entry as <origin, destinations>.
     *Step 2: We should order the destination list for each entry in lexical order,
     *        by Greedy strategy that picks the smallest lexical order.
     *        As an alternative solution, one could use PriorityQueue in the first step to keep the list of destinations.
     *Step 3: We kick off the backtracking traversal on the above graph.
     *        1. At the beginning of the backtracking function, as the bottom case,
     *           we check if we have already obtained a valid itinerary.
     *        2. Otherwise we enumerate the next destinations in order.
     *        3. We mark the status of visit, before and after each backtracking loop.
     */

    //Cannot understand Hierholzer's Algorithm. Cuz seemingly it only fits this specific condition.
    HashMap<String, List<String>> flightMap = new HashMap<>();
    HashMap<String, boolean[]> visitMap = new HashMap<>();
    //List<String> res = new ArrayList<>();
    List<String> res = null;
    int flights = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        //Step 1: Build Graph
        buildGraph(tickets);
        flights = tickets.size()+1;
        //Step 2: order the destinations and initialize isVisited[].
        for(Map.Entry<String, List<String>> entry: this.flightMap.entrySet()){
            //Sort it to make it greedy.
            Collections.sort(entry.getValue());
            this.visitMap.put(entry.getKey(),
                    new boolean[entry.getValue().size()]);
        }

        LinkedList<String> route = new LinkedList<>();
        //LinkedList<String> route = new LinkedList<String>();
        String origin = "JFK";
        route.add(origin);

        dfs(origin, route);
        return this.res;
    }

    public void buildGraph(List<List<String>> tickets){
        for(List<String> ticket:tickets){
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if(this.flightMap.containsKey(origin)){
                List<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            }else{
                List<String> destList = new ArrayList<>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }
    }

    //if type of route is List<>, we cannot initialize res as null or it would be nullPointerException.
    //And type of List<> cannot use method like clone() or pollLast().
    public boolean dfs(String origin, LinkedList<String> route){
        if(route.size() == this.flights){
            this.res = (List<String>) route.clone();

            //for(String airport:route)
            //    this.res.add(airport);

            return true;
        }

        if(!this.flightMap.containsKey(origin))
            return false;

        int i = 0;
        boolean[] isVisited = this.visitMap.get(origin);
        for(String dest: flightMap.get(origin)){
            //Avoid dead-loop or repeated route.
            if(!isVisited[i]){
                isVisited[i] = true;
                route.add(dest);
                boolean isDone = dfs(dest, route);
                //route.remove(route.size()-1);
                route.pollLast();
                isVisited[i] = false;

                if(isDone) return true;
            }
            i++;
        }

        return false;
    }
}
