package dtprogrammer.github.io.algo;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                Comparable temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
    }

    public static void main(String args[]) {
        Integer[] data = {23, 56, 33, 0, 9, 56, 87};
        SelectionSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
