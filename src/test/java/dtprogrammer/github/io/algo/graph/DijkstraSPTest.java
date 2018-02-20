package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.graph.DirectedEdge;
import dtprogrammer.github.io.ds.graph.EdgeWeightedDigraph;
import org.junit.Assert;

public class DijkstraSPTest {

    @org.junit.Test
    public void test() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 5));
        graph.addEdge(new DirectedEdge(0, 4, 9));
        graph.addEdge(new DirectedEdge(0, 7, 8));
        graph.addEdge(new DirectedEdge(1, 2, 12));
        graph.addEdge(new DirectedEdge(1, 3, 15));
        graph.addEdge(new DirectedEdge(1, 7, 4));
        graph.addEdge(new DirectedEdge(2, 3, 3));
        graph.addEdge(new DirectedEdge(2, 6, 11));
        graph.addEdge(new DirectedEdge(3, 6, 9));
        graph.addEdge(new DirectedEdge(4, 5, 4));
        graph.addEdge(new DirectedEdge(4, 6, 20));
        graph.addEdge(new DirectedEdge(4, 7, 5));
        graph.addEdge(new DirectedEdge(5, 2, 1));
        graph.addEdge(new DirectedEdge(5, 6, 13));
        graph.addEdge(new DirectedEdge(7, 5, 6));
        graph.addEdge(new DirectedEdge(7, 2, 7));
        DijkstraSP sp = new DijkstraSP(graph, 0);
        Assert.assertTrue(sp.hasPathTo(6));
        Assert.assertEquals(25, sp.distTo(6), 0.0000);
        Assert.assertTrue(sp.hasPathTo(3));
        Assert.assertEquals(17, sp.distTo(3), 0.0000);
    }
}
