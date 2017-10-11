package dtprogrammer.github.io.other.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Checks if the given graph is Bipartite
 * http://www.geeksforgeeks.org/bipartite-graph/
 */
public class Bipartite {
    boolean isBipartite(int G[][], int V) {
        int[] color = new int[V];

        // -1 represent uncolored i.e. unvisited too
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartite(G, V, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] G, int V, int src, int[] color) {

        // visit the source
        color[src] = 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();

            for (int i = 0; i < V; i++) {
                // if there is an edge and the other node is unvisited
                if (G[curNode][i] == 1 && color[i] == -1) {
                    queue.add(i);
                    color[i] = 1 - color[curNode];
                } else if (G[curNode][i] == 1 && color[i] == color[curNode]) {
                    return false;
                }
            }

        }
        return true;
    }
}
