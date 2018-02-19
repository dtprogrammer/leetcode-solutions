package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.graph.Edge;
import dtprogrammer.github.io.ds.graph.EdgeWeightedGraph;
import org.junit.Assert;

public class KruskalMSTTest {

    @org.junit.Test
    public void test() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(0, 7, 0.16000));
        graph.addEdge(new Edge(2, 3, 0.17000));
        graph.addEdge(new Edge(1, 7, 0.19000));
        graph.addEdge(new Edge(0, 2, 0.26000));
        graph.addEdge(new Edge(5, 7, 0.28000));
        graph.addEdge(new Edge(4, 5, 0.35000));
        graph.addEdge(new Edge(6, 2, 0.40000));
        KruskalMST mst = new KruskalMST(graph);
        Assert.assertEquals(1.81000, mst.getWeight(), 0.00000);
    }
}
