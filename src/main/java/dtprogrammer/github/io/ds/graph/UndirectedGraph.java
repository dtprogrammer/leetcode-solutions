package dtprogrammer.github.io.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of Undirected Graph.
 * Reference: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Graph.java.html
 */
public class UndirectedGraph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public UndirectedGraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Vertices must be a non-negative number");
        }

        this.V = V;
        this.E = 0;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public UndirectedGraph(int V, int[][] edges) {
        if (V < 0 || E < 0) {
            throw new IllegalArgumentException("Vertices and edges must be a non-negative number");
        }
        this.V = V;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<>();
        }
        if (edges.length > 0) {
            for (int i = 0; i < edges.length; i++) {
                if (edges[i].length > 0) {
                    for (int j = 0; j < edges[i].length; j++) {
                        addEdge(i, edges[i][j]);
                    }
                }
            }
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
    }

    private void validateVertex(int w) {
        if (w < 0 || w >= V) {
            throw new IllegalArgumentException("Vertex must be in range " + V);
        }
    }

    /**
     * Initializes a new graph that is a deep copy of {@code G}.
     *
     * @param G the graph to copy
     */
    public UndirectedGraph(UndirectedGraph G) {
        this.V = G.V;
        this.E = G.E;
        this.adj = new LinkedList[G.V];

        for (int i = 0; i < G.V; i++) {
            List<Integer> copy = new LinkedList<>();
            copy.addAll(G.adj[i]);
            this.adj[i] = copy;
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public List<Integer>[] getAdj() {
        return adj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedGraph that = (UndirectedGraph) o;
        return V == that.V &&
                E == that.E &&
                Arrays.equals(adj, that.adj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(V, E, adj);
    }

    @Override
    public String toString() {
        StringBuilder edges = new StringBuilder();
        for (int i = 0; i < V; i++) {
            edges.append(System.lineSeparator());
            edges.append(i);
            edges.append(adj[i]);
        }
        return "UndirectedGraph{" +
                "\nV=" + V +
                "\nE=" + E +
                "\nadj=" + edges.toString() +
                '}';
    }
}
