package dtprogrammer.github.io.algo;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    Comparable temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{23, 56, 33, 0, 9, 56, 87};
        InsertionSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
