package dtprogrammer.github.io.algo;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] data) {
        Comparable[] aux = new Comparable[data.length];
        sort(data, aux, 0, data.length - 1);
    }

    private static void merge(Comparable[] data, Comparable[] aux, int low, int mid, int high) {

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

    private static void sort(Comparable[] data, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(data, aux, low, mid);
        sort(data, aux, mid + 1, high);

        merge(data, aux, low, mid, high);
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{45, 23, 56, 78, 3, 4, 3, 9};
        MergeSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
