package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.MinPQWithDecreaseKey;
import dtprogrammer.github.io.ds.graph.Edge;
import dtprogrammer.github.io.ds.graph.EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMST {

    MinPQWithDecreaseKey<Integer> pq = new MinPQWithDecreaseKey<>();
    Map<Integer, Edge> edgeTo = new HashMap<>();
    List<Edge> mst = new ArrayList<>();
    double mstWeight;

    public PrimsMST(EdgeWeightedGraph graph) {

        // initialize the pq with infinite positive weight for all vertices
        for (int v = 0; v < graph.getV(); v++) {
            pq.add(v, Double.POSITIVE_INFINITY);
        }

        // start with vertex 0 by decreasing its weight to min
        pq.update(0, 0);

        while (!pq.isEmpty()) {
            Integer currentVertex = pq.extractMin();

            Edge edge = edgeTo.get(currentVertex);
            if (edge != null) {
                mst.add(edge);
                mstWeight += edge.getWeight();
            }

            // iterate through all adjacent vertices
            for (Edge adjEdge : graph.adj(currentVertex)) {
                int adjVertex = adjEdge.other(currentVertex);

                // check if the adjacent vertex exists in the pq and if the weight is greater
                if (pq.contains(adjVertex) && pq.getWeight(adjVertex) > adjEdge.getWeight()) {
                    // decrease the value of weight for the vertex to this edge
                    pq.update(adjVertex, adjEdge.getWeight());
                    // add/update edgeTo data
                    edgeTo.put(adjVertex, adjEdge);
                }
            }
        }
    }

    public List<Edge> getMst() {
        return mst;
    }

    public double getMstWeight() {
        return mstWeight;
    }
}
