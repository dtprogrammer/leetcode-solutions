package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.graph.UndirectedGraph;

public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    public DepthFirstSearch(UndirectedGraph G, int s) {
        this.marked = new boolean[G.getV()];
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(UndirectedGraph graph, int start) {
        count++;
        marked[start] = true;
        for (Integer neighbor : graph.getAdj()[start]) {
            if (!marked[neighbor]) {
                dfs(graph, neighbor);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public boolean isConnected(int v) {
        validateVertex(v);
        return marked[v];
    }

    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= marked.length) {
            throw new IllegalArgumentException();
        }
    }
}
