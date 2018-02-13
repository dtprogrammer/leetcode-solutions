package dtprogrammer.github.io.algo;

import java.util.Arrays;

public class MergeSortBU {

    public static void merge(Comparable[] data, Comparable[] aux, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            aux[i] = data[i];
        }

        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                data[k] = aux[j++];
            } else if (j > high) {
                data[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                data[k] = aux[i++];
            } else {
                data[k] = aux[j++];
            }
        }
    }

    public static void sort(Comparable[] data) {
        Comparable[] aux = new Comparable[data.length];
        for (int len = 1; len < data.length; len *= 2) {
            for (int low = 0; low < data.length - len; low += len + len) {
                int mid = low + len - 1;
                int high = Math.min(low + len + len - 1, data.length - 1);
                merge(data, aux, low, mid, high);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{8, 6, 9, 5, 1, 2};
        MergeSortBU.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
