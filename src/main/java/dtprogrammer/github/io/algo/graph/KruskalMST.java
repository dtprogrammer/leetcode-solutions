package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.graph.Edge;
import dtprogrammer.github.io.ds.graph.EdgeWeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {

    class UF {
        private final int[] parent;
        private final byte[] rank;

        UF(int n) {
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findSet(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            if (i < 0 || j < 0 || i >= parent.length || j >= parent.length) {
                throw new IllegalArgumentException();
            }
            int parent1 = findSet(i);
            int parent2 = findSet(j);

            if (parent1 == parent2) {
                return;
            }

            if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent[parent2];
            } else {
                parent[parent2] = parent[parent1];
                if (rank[parent1] < rank[parent2]) {
                    rank[parent2]++;
                }
            }
        }
    }

    private double weight;
    private Queue<Edge> mst = new LinkedList<>();

    public KruskalMST(EdgeWeightedGraph graph) {
        PriorityQueue<Edge> minPQ = new PriorityQueue<>(graph.getE());
        for (Edge edge : graph.getEdges()) {
            minPQ.offer(edge);
        }

        UF uf = new UF(graph.getV());

        while (!minPQ.isEmpty() || mst.size() != graph.getV() - 1) {
            Edge minEdge = minPQ.poll();
            int v = minEdge.either();
            int w = minEdge.other(v);

            int parent1 = uf.findSet(v);
            int parent2 = uf.findSet(w);

            if (parent1 == parent2) {
                continue;
            } else {
                uf.union(v, w);
                mst.add(minEdge);
                weight += minEdge.getWeight();
            }
        }
    }

    public double getWeight() {
        return weight;
    }

    public Queue<Edge> getMst() {
        return mst;
    }
}
