package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.MinPQWithDecreaseKey;
import dtprogrammer.github.io.ds.graph.DirectedEdge;
import dtprogrammer.github.io.ds.graph.EdgeWeightedDigraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DijkstraSP {
    private final DirectedEdge[] edgeTo;
    private final double[] distTo;
    private MinPQWithDecreaseKey<Integer> heap;

    public DijkstraSP(EdgeWeightedDigraph digraph, int origin) {
        for (DirectedEdge directedEdge : digraph.getEdges()) {
            if (directedEdge.getWeight() < 0) {
                throw new IllegalArgumentException("Edge has a negative weight");
            }
        }

        distTo = new double[digraph.getV()];
        edgeTo = new DirectedEdge[digraph.getV()];
        validateVertex(origin);
        heap = new MinPQWithDecreaseKey<>();
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        distTo[origin] = 0.0;
        heap.add(origin, distTo[origin]);

        while (!heap.isEmpty()) {
            int nearestVertex = heap.extractMin();
            for (DirectedEdge directedEdge : digraph.adj(nearestVertex)) {
                relax(directedEdge);
            }
        }
    }

    private void relax(DirectedEdge directedEdge) {
        int src = directedEdge.getSource();
        int dest = directedEdge.getDestination();
        if (distTo[dest] > distTo[src] + directedEdge.getWeight()) {
            distTo[dest] = distTo[src] + directedEdge.getWeight();
            edgeTo[dest] = directedEdge;
            if (heap.contains(dest)) {
                heap.update(dest, distTo[dest]);
            } else {
                heap.add(dest, distTo[dest]);
            }
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= distTo.length) {
            throw new IllegalArgumentException("Vertex is not in range");
        }
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        List<DirectedEdge> path = new LinkedList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getSource()]) {
            path.add(e);
        }
        Collections.reverse(path);
        return path;
    }
}
