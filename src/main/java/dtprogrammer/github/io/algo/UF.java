package dtprogrammer.github.io.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Union find based on rank with path optimization
 **/
public class UF {

    class Node {
        String data;
        int rank;
        Node parent;

        private Node(String data) {
            this.data = data;
            this.rank = 0;
            this.parent = this;
        }
    }

    Map<String, Node> sets;

    private UF() {
        sets = new HashMap<>();
    }

    public void makeSet(String data) {
        Node node = new Node(data);
        sets.put(data, node);
    }

    private Node findSet(Node node) {
        while (node != node.parent) {
            node.parent = sets.get(node.parent.data).parent;
            node = node.parent;
        }
        return node;
    }

    public String findSet(String data) {
        return findSet(sets.get(data)).data;
    }

    public void union(String data1, String data2) {
        Node parent1 = findSet(sets.get(data1));
        Node parent2 = findSet(sets.get(data2));

        if (parent1 == parent2) {
            return;
        }

        if (parent1.rank < parent2.rank) {
            parent1.parent = parent2;
        } else {
            parent2.parent = parent1;
            if (parent1.rank == parent2.rank) {
                parent1.rank++;
            }
        }
    }

    public static void main(String[] args) {
        UF ds = new UF();
        ds.makeSet("1");
        ds.makeSet("2");
        ds.makeSet("3");
        ds.makeSet("4");
        ds.makeSet("5");
        ds.makeSet("6");
        ds.makeSet("7");

        ds.union("1", "2");
        ds.union("2", "3");
        ds.union("4", "5");
        ds.union("6", "7");
        ds.union("5", "6");
        ds.union("3", "7");

        System.out.println(ds.findSet("1"));
        System.out.println(ds.findSet("2"));
        System.out.println(ds.findSet("3"));
        System.out.println(ds.findSet("4"));
        System.out.println(ds.findSet("5"));
        System.out.println(ds.findSet("6"));
        System.out.println(ds.findSet("7"));
    }
}
