package dtprogrammer.github.io.p399;

import java.util.*;

/**
 * 399. Evaluate Division
 */
public class Solution {
    class EquationInfo {
        String denominator;
        double value;

        public EquationInfo(String denominator, double value) {
            this.denominator = denominator;
            this.value = value;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || values == null || equations.length != values.length) {
            return new double[0];
        }
        Map<String, List<EquationInfo>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            List<EquationInfo> curEq = graph.getOrDefault(equations[i][0], new ArrayList<>());
            curEq.add(new EquationInfo(equations[i][1], values[i]));
            graph.put(equations[i][0], curEq);
            curEq = graph.getOrDefault(equations[i][1], new ArrayList<>());
            curEq.add(new EquationInfo(equations[i][0], 1 / values[i]));
            graph.put(equations[i][1], curEq);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dfs(graph, queries[i][0], queries[i][1], new HashSet<>(), 1.0);
            result[i] = result[i] == 0.0 ? -1.0 : result[i];
        }
        return result;
    }

    private double dfs(Map<String, List<EquationInfo>> graph, String start, String end, Set<String> path,
                       double value) {
        // this is needed because we have two connection a to b and then b to a so when we reach b from a and then
        // run dfs from there we will see a which is already on path so we simply return
        if (path.contains(start)) return 0.0;
        if (!graph.containsKey(start)) return 0.0;
        if (start.equalsIgnoreCase(end)) return value;
        path.add(start);

        double tmp = 0;
        for (EquationInfo equationInfo : graph.get(start)) {
            tmp = dfs(graph, equationInfo.denominator, end, path, value * equationInfo.value);
            if (tmp != 0.0) break;
        }
        path.remove(start);
        return tmp;
    }
}
