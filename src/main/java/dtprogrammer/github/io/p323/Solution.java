package dtprogrammer.github.io.p323;

/**
 * 323. Number of Connected Components in an Undirected Graph
 */
public class Solution {
    class UF {
        private final int[] parent;
        private final byte[] rank;
        private int count;

        UF(int n) {
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
            count = n;
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
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int countComponents(int n, int[][] edges) {

        if (n <= 0) {
            return 0;
        }

        UF uf = new UF(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }
}
