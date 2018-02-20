package dtprogrammer.github.io.ds.graph;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        if (v < 0 || w < 0 || Double.isNaN(weight)) {
            throw new IllegalArgumentException();
        }
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int i) {
        if (i == v) return w;
        if (i == w) return v;
        throw new IllegalArgumentException("Incorrect vertex");
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(v);
        builder.append("-");
        builder.append(w);
        builder.append(" (");
        builder.append(weight);
        builder.append(")");
        return builder.toString();
    }
}
