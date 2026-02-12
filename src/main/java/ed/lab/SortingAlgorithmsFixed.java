package ed.lab;

import java.util.Random;

public class SortingAlgorithmsFixed {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1, /*pivotSelector*/ Pivot.HIGH);
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1, Pivot.LOW);
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1, Pivot.RANDOM);
    }

    private enum Pivot { LOW, HIGH, RANDOM }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, Pivot pivotType) {
        if (low < high) {
            int pivotIndex;
            switch (pivotType) {
                case LOW: pivotIndex = low; break;
                case HIGH: pivotIndex = high; break;
                default: pivotIndex = low + new Random().nextInt(high - low + 1); break;
            }
            int pi = partition(array, low, high, pivotIndex);
            quickSort(array, low, pi - 1, pivotType);
            quickSort(array, pi + 1, high, pivotType);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, int pivotIndex) {
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, high); // Move pivot to end
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j].compareTo(pivotValue) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high); // Move pivot to its final place
        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
