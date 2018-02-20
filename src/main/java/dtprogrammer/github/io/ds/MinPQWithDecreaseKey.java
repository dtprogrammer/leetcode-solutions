package dtprogrammer.github.io.ds;

import java.util.*;

/**
 * Implementation of a Min Binary Heap (Priority Queue) with Map to support
 * update and delete operation.
 */
public class MinPQWithDecreaseKey<Key> implements Iterable<Key> {

    // Stores the data with its weight
    public class Node {
        final Key data;
        double weight;

        public Node(Key data, double weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    private final List<Node> pq = new ArrayList<>();
    private final Map<Key, Integer> heapPosition = new HashMap<>();

    /**
     * Checks whether a key exists in heap or not
     */
    public boolean contains(Key data) {
        return heapPosition.containsKey(data);
    }

    /**
     * Checks whether the heap is empty or not
     */
    public boolean isEmpty() {
        return pq.size() == 0;
    }

    /**
     * Returns the size of the heap
     */
    public int size() {
        return pq.size();
    }

    /**
     * Returns the weight of the minimum element in the heap
     */
    public double minWeight() {
        return getMin().weight;
    }

    public double getWeight(Key data) {
        if (!contains(data)) {
            throw new IllegalArgumentException("Key does exists in heap.");
        }
        Integer position = heapPosition.get(data);
        return pq.get(position).weight;
    }

    /**
     * Adds the given key with the given weight on to the heap
     */
    public void add(Key data, double weight) {
        if (contains(data)) {
            throw new IllegalArgumentException("Key already exists in heap.");
        }
        Node node = new Node(data, weight);
        pq.add(node);
        heapPosition.put(data, pq.size() - 1);
        swim(pq.size() - 1);
    }

    /**
     * Updates the given key if its exists in the heap with the given weight
     */
    public void update(Key data, double updatedWeight) {
        if (!contains(data)) {
            throw new IllegalArgumentException("Key does exists in heap.");
        }
        Integer position = heapPosition.get(data);
        Node node = pq.get(position);
        node.weight = updatedWeight;
        swim(position);
        sink(position);
    }

    /**
     * Deletes the given key from the heap if it exists in the heap
     */
    public void delete(Key data) {
        if (!contains(data)) {
            throw new IllegalArgumentException("Key does exists in heap.");
        }
        Integer position = heapPosition.get(data);
        exch(position, pq.size() - 1);
        pq.remove(pq.size() - 1);
        heapPosition.remove(data);
        sink(position);
    }

    /**
     * Returns the minimum element on the heap
     */
    public Key peakMin() {
        return getMin().data;
    }

    /**
     * Removes the minimum element from the heap
     */
    public Key extractMin() {
        Node min = getMin();
        exch(0, pq.size() - 1);
        pq.remove(pq.size() - 1);
        heapPosition.remove(min.data);
        sink(0);
        return min.data;
    }

    /**
     * visible for testing
     */
    int getHeapPositionSize() {
        return heapPosition.size();
    }

    private Node getMin() {
        if (pq.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return pq.get(0);
    }

    private void swim(int position) {
        while (position > 0 && greater((position - 1) / 2, position)) {
            exch((position - 1) / 2, position);
            position = (position - 1) / 2;
        }
    }

    private void sink(int position) {
        while ((2 * position + 1) <= pq.size() - 1) {
            int child = 2 * position + 1;
            if (child < pq.size() - 1 && greater(child, child + 1)) child++;
            if (greater(child, position)) break;
            exch(child, position);
            position = child;
        }
    }

    private void exch(int i, int j) {
        heapPosition.put(pq.get(i).data, j);
        heapPosition.put(pq.get(j).data, i);
        Collections.swap(pq, i, j);
    }

    private boolean greater(int greaterIndex, int lesserIndex) {
        return pq.get(greaterIndex).weight > pq.get(lesserIndex).weight;
    }

    @Override
    public Iterator<Key> iterator() {
        return new MinPQWithDecreaseKeyIterator();
    }

    private class MinPQWithDecreaseKeyIterator implements Iterator<Key> {
        private MinPQWithDecreaseKey<Key> copy;

        public MinPQWithDecreaseKeyIterator() {
            this.copy = new MinPQWithDecreaseKey<>();
            for (Node aPq : pq) {
                copy.add(aPq.data, aPq.weight);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.extractMin();
        }
    }
}
