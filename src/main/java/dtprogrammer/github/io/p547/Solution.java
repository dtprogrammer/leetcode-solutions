package dtprogrammer.github.io.p547;

/**
 * 547. Friend Circles
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

    public int findCircleNum(int[][] M) {

        if (M == null || M.length == 0) {
            return 0;
        }
        UF uf = new UF(M.length);

        for (int i = 0; i < M.length - 1; i++) {
            for (int j = i + 1; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
