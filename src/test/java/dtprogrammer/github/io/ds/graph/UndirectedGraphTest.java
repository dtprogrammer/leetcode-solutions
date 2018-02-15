package dtprogrammer.github.io.ds.graph;

import org.junit.Assert;

public class UndirectedGraphTest {
    @org.junit.Test
    public void test() {
        UndirectedGraph graph = GraphTestUtil.getUndirectedGraph();
        Assert.assertEquals(13, graph.getV());
        Assert.assertEquals(26, graph.getE());
        UndirectedGraph anotherGraph = new UndirectedGraph(graph);
        Assert.assertTrue(graph.equals(anotherGraph));
        anotherGraph.addEdge(2, 5);
        Assert.assertFalse(graph.equals(anotherGraph));
    }
}
