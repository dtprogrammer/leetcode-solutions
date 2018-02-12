package dtprogrammer.github.io.algo;

public class Heap {

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        // construct heap
        int n = pq.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(pq, i, n);
        }

        // sort
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }

    }

    private static void sink(Comparable[] pq, int k, int size) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(pq, j, j + 1)) {
                j++;
            }
            if (less(pq, j, k)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int lessIndex, int moreIndex) {
        return pq[lessIndex - 1].compareTo(pq[moreIndex - 1]) < 0;
    }

    private static void exch(Comparable[] pq, int i, int j) {
        Comparable temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{23, 44, 23, 34, 99, 54, 0};
        Heap.sort(data);
        System.out.println("Sorted order: ");
        for (Integer datum : data) {
            System.out.println(datum);
        }
    }
}
