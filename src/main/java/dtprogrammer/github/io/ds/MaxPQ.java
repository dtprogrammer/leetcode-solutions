package dtprogrammer.github.io.ds;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Max - Heap or Priority queue implementation
 * Reference: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/MaxPQ.java.html
 *
 * @param <Key>
 */
public class MaxPQ<Key> implements Iterable<Key> {

    private Key[] pq;
    private Comparator<Key> comparator;
    private int size;

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        size = 0;
    }

    public MaxPQ(Comparator<Key> comparator) {
        this(comparator, 1);
    }

    public MaxPQ(Comparator<Key> comparator, int initCapacity) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        size = 0;
    }

    public MaxPQ(Key[] keys) {
        int n = keys.length;
        pq = (Key[]) new Object[n + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int i = n / 2; i >= 1; i--) {
            sink(i);
        }
        isMaxHeap();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param x the new key to add to this priority queue
     */
    public void insert(Key x) {
        if (size == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++size] = x;
        swim(size);
        isMaxHeap();
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMax() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Key deleted = pq[1];
        exch(1, size);
        size--;
        sink(1);
        pq[size + 1] = null;
        if (size > 0 && size == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        isMaxHeap();
        return deleted;
    }

    private void resize(int newCapacity) {
        if (newCapacity <= size) {
            throw new IllegalArgumentException();
        }

        Key[] resized = (Key[]) new Object[newCapacity];

        for (int i = 1; i <= size; i++) {
            resized[i] = pq[i];
        }
        pq = resized;
    }

    private void isMaxHeap() {
        if (!isMaxHeap(1)) {
            throw new IllegalStateException();
        }
    }

    private boolean isMaxHeap(int k) {
        if (k > size) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= size && less(k, left)) return false;
        if (right <= size && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (less(j, k)) {
                break;
            }
            exch(j, k);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }


    private boolean less(int lessIndex, int moreIndex) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[lessIndex]).compareTo(pq[moreIndex]) < 0;
        } else {
            return comparator.compare(pq[lessIndex], pq[moreIndex]) < 0;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return new MaxHeapIterator();
    }

    private class MaxHeapIterator implements Iterator<Key> {
        private MaxPQ<Key> copy;

        public MaxHeapIterator() {
            if (comparator == null) {
                copy = new MaxPQ<>(size());
            } else {
                copy = new MaxPQ<>(comparator, size());
            }
            for (int i = 1; i <= size; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMax();
        }
    }

    public static void main(String[] args) {
        MaxPQ<Integer> queue = new MaxPQ<>();
        queue.insert(23);
        queue.insert(43);
        queue.insert(67);
        queue.insert(99);
        queue.insert(24);
        queue.insert(27);
        queue.insert(23);
        System.out.println("Current size of PQ is: " + queue.size());
        System.out.println("In decreasing order is: ");
        for (Integer value : queue) {
            System.out.println(value);
        }
        System.out.println("Deleting max: " + queue.delMax());
        System.out.println("Current size of PQ is: " + queue.size());
        System.out.println("In decreasing order is: ");
        for (Integer value : queue) {
            System.out.println(value);
        }
        System.out.println("inserting");
        queue.insert(53);
        System.out.println("Current size of PQ is: " + queue.size());
        System.out.println("In decreasing order is: ");
        for (Integer value : queue) {
            System.out.println(value);
        }
    }
}