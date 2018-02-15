package dtprogrammer.github.io.ds.graph;

import org.junit.Assert;

public class UndirectedGraphTest {
    @org.junit.Test
    public void test() {
        int[][] edges = new int[][]{
                {6, 2, 1, 5},
                {0},
                {0},
                {5, 4},
                {5, 6, 3},
                {3, 4, 0},
                {0, 4},
                {8},
                {7},
                {11, 10, 12},
                {9},
                {9, 12},
                {11, 9}};

        UndirectedGraph graph = new UndirectedGraph(13, edges);
        Assert.assertEquals(13, graph.getV());
        Assert.assertEquals(26, graph.getE());
        UndirectedGraph anotherGraph = new UndirectedGraph(graph);
        Assert.assertTrue(graph.equals(anotherGraph));
        anotherGraph.addEdge(2, 5);
        Assert.assertFalse(graph.equals(anotherGraph));
    }
}
