package dtprogrammer.github.io.algo.graph;

import dtprogrammer.github.io.ds.graph.GraphTestUtil;
import dtprogrammer.github.io.ds.graph.UndirectedGraph;
import org.junit.Assert;

public class DepthFirstSearchTest {

    @org.junit.Test
    public void test() {
        UndirectedGraph graph = GraphTestUtil.getUndirectedGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 11);
        Assert.assertTrue(dfs.isConnected(9));
        Assert.assertTrue(dfs.isConnected(12));
        Assert.assertFalse(dfs.isConnected(0));
        Assert.assertEquals(4, dfs.getCount());
    }
}
