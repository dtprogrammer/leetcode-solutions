package dtprogrammer.github.io.ds.graph;

public class GraphTestUtil {
    public static UndirectedGraph getUndirectedGraph() {
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

        return new UndirectedGraph(13, edges);
    }
}
