package dtprogrammer.github.io.ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private final List<Edge>[] edges;

    public EdgeWeightedGraph(int v) {
        if (v < 0) throw new IllegalArgumentException("Vertices must be non-negative");
        this.V = v;
        this.E = 0;
        this.edges = (List<Edge>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedGraph(int v, int[][] edges) {
        this(v);
        if (edges == null || edges.length == 0) throw new IllegalArgumentException();
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public void addEdge(int v, int w, int weight) {
        addEdge(new Edge(v, w, weight));
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        validateVertex(v);
        validateVertex(edge.other(v));
        edges[v].add(edge);
        edges[edge.other(v)].add(edge);
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public List<Edge> getEdges() {
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            int selfLoops = 0;
            for (Edge edge : adj(i)) {
                if (edge.other(i) > i) {
                    edges.add(edge);
                } else if (edge.other(i) == i) {
                    // self loop only add one
                    if (selfLoops % 2 == 0) {
                        edges.add(edge);
                        selfLoops++;
                    }
                }
            }
        }
        return edges;
    }

    public List<Edge> adj(int v) {
        validateVertex(v);
        return edges[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new NoSuchElementException("Vertex does not exist");
        }
    }
}
