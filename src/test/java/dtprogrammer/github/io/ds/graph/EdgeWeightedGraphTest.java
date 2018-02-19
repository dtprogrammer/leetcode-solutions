package dtprogrammer.github.io.ds.graph;

public class EdgeWeightedGraphTest {

    @org.junit.Test
    public void test() throws Exception {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(4, new int[][]{{0, 1, 5}, {0, 2, 3},
                {3, 0, 6},
                {1, 3, 7},
                {2, 1, 4},
                {2, 3, 5}});

    }
}
