package dtprogrammer.github.io.ds.graph;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int src;
    private final int dest;
    private final double weight;

    public DirectedEdge(int src, int dest, double weight) {
        if (src < 0 || dest < 0 || Double.isNaN(weight)) {
            throw new IllegalArgumentException();
        }
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSource() {
        return src;
    }

    public int getDestination() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(src);
        builder.append("->");
        builder.append(dest);
        builder.append(" (");
        builder.append(weight);
        builder.append(")");
        return builder.toString();
    }
}
