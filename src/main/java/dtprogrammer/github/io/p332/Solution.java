package dtprogrammer.github.io.p332;

import java.util.*;

/**
 * 332. Reconstruct Itinerary
 */
public class Solution {
    List<String> iternary;

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return new ArrayList<>();
        }

        // create a graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] curTicket : tickets) {
            PriorityQueue<String> adj = graph.getOrDefault(curTicket[0], new PriorityQueue<>());
            adj.offer(curTicket[1]);
            graph.put(curTicket[0], adj);
        }
        iternary = new LinkedList<>();
        dfs("JFK", graph);
        return iternary;
    }

    private void dfs(String origin, Map<String, PriorityQueue<String>> graph) {
        PriorityQueue<String> curDest = graph.get(origin);
        while (curDest != null && !curDest.isEmpty())
            dfs(curDest.poll(), graph);
        iternary.add(0, origin);
    }
}
