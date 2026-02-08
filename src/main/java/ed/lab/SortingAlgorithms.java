package ed.lab;

import java.util.Arrays;

public class SortingAlgorithms {
    static int HIGHPIVOT = 1;
    static int LOWPIVOT = 2;
    static int MIDPIVOT = 3;
    public static <T extends Comparable<T>>void highPivotQuickSort(T[] array){

    }
    public static <T extends Comparable<T>>void lowPivotQuickSort(T[] array){

    }
    public static <T extends Comparable<T>>void randomPivotQuickSort(T[] array){

    }
    // Toma arreglo, low, high y pivote
    // devuelve indice de pivote
    public static <T extends Comparable<T>> int partition (T[] array, int low, int high, int pivot){
        int i = low -1;
        for (int d = 0; d < high; d++){
            if(array[d].compareTo(array[pivot]) < 0){
                i ++;
                swap(array, i,d);
            }
        }
        swap (array, i+1, high);
        return i + 1;
    }
    public static <T extends Comparable<T>>void swap(T[] array, int i, int d){
        T temp = array [i];
        array[i] = array[d];
        array[d] = temp;
    }
    public static <T extends Comparable<T>>void quickSort (T[] array, int low, int high, int pivot){
        //Caso base
        if (low >= high){
            return;
        }
        // parte en dos al arreglo
        int pi = partition(array, 0, array.length -1,pivot);
        if(pivot == HIGHPIVOT){
            // Llamada recursiva
            quickSort(array, low, pivot - 1,pivot-1);

        }
        if(pivot == LOWPIVOT){
            // Llamada recursiva
            quickSort(array, low, pivot - 1,pivot-1);
        }
        if(pivot == MIDPIVOT){
            // Llamada recursiva
            quickSort(array, low, pivot - 1,pivot-1);
        }

    }

}
