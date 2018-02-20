package dtprogrammer.github.io.ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private final List<DirectedEdge>[] edges;
    private final int[] inDegree;

    public EdgeWeightedDigraph(int v) {
        if (v < 0) throw new IllegalArgumentException("Vertices must be non-negative");
        this.V = v;
        this.E = 0;
        this.edges = (List<DirectedEdge>[]) new LinkedList[v];
        this.inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedDigraph(int v, int[][] edges) {
        this(v);
        if (edges == null || edges.length == 0) throw new IllegalArgumentException();
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public void addEdge(int v, int w, int weight) {
        addEdge(new DirectedEdge(v, w, weight));
    }

    public void addEdge(DirectedEdge edge) {
        validateVertex(edge.getSource());
        validateVertex(edge.getDestination());
        edges[edge.getSource()].add(edge);
        inDegree[edge.getDestination()]++;
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public List<DirectedEdge> getEdges() {
        List<DirectedEdge> edges = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            edges.addAll(adj(i));
        }
        return edges;
    }

    public List<DirectedEdge> adj(int v) {
        validateVertex(v);
        return edges[v];
    }

    public int getInDegree(int v) {
        validateVertex(v);
        return inDegree[v];
    }

    public int getOutDegree(int v) {
        validateVertex(v);
        return edges[v].size();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new NoSuchElementException("Vertex does not exist");
        }
    }
}
