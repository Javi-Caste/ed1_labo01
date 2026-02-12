package ed.lab;

import java.util.Arrays;

public class SortingAlgorithms {
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int pi = partition(array, 0, array.length - 1, array.length - 1);

        T[] left = Arrays.copyOfRange(array, 0, pi);
        T[] right = Arrays.copyOfRange(array, pi + 1, array.length);

        highPivotQuickSort(left);
        highPivotQuickSort(right);

        // Combinar resultados
        System.arraycopy(left, 0, array, 0, left.length);
        array[left.length] = array[pi]; // Colocar el pivote en su posición
        System.arraycopy(right, 0, array, left.length + 1, right.length);

    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int pi = partition(array, 0, array.length - 1, 0);

        T[] left = Arrays.copyOfRange(array, 0, pi);
        T[] right = Arrays.copyOfRange(array, pi + 1, array.length);

        lowPivotQuickSort(left);
        lowPivotQuickSort(right);

        // Combinar resultados
        System.arraycopy(left, 0, array, 0, left.length);
        array[left.length] = array[pi]; // Colocar el pivote en su posición
        System.arraycopy(right, 0, array, left.length + 1, right.length);

    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int pivotIndex = (int) (Math.random() * array.length);
        int pi = partition(array, 0, array.length - 1, pivotIndex);
        T[] left = Arrays.copyOfRange(array, 0, pi);
        T[] right = Arrays.copyOfRange(array, pi + 1, array.length);

        randomPivotQuickSort(left);
        randomPivotQuickSort(right);

        // Combinar resultados
        System.arraycopy(left, 0, array, 0, left.length);
        array[left.length] = array[pi]; // Colocar el pivote en su posición
        System.arraycopy(right, 0, array, left.length + 1, right.length);

    }

    // Toma arreglo, low, high y pivote
    // devuelve indice de pivote
    public static <T extends Comparable<T>> int partition(T[] array, int low, int high, int pivotIndex) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        // Move pivot to end first
        swap(array, pivotIndex, high);
        T pivotValue = array[high];
        
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivotValue) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int d) {
        T temp = array[i];
        array[i] = array[d];
        array[d] = temp;
    }

}
