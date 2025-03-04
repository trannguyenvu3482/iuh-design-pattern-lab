package com.fit;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

interface ArraySort {
    void sort(int[] array);
}

class BubbleSort implements ArraySort {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
}

class QuickSort implements ArraySort {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class MergeSort implements ArraySort {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(array, l, L, 0, n1);
        for (int j = 0; j < n2; j++)
            R[j] = array[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

}

// Decorator
abstract class ArraySorterDecorator implements ArraySort {
    protected ArraySort arraySort;

    public ArraySorterDecorator(ArraySort arraySort) {
        this.arraySort = arraySort;
    }

    @Override
    public void sort(int[] array) {
        arraySort.sort(array);
    }
}

// Concrete Decorator 1
class LoggingArraySorterDecorator extends ArraySorterDecorator {
    public LoggingArraySorterDecorator(ArraySort arraySort) {
        super(arraySort);
    }

    @Override
    public void sort(int[] array) {
        System.out.println("Sorting array: " + Arrays.toString(array));
        super.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

// Concrete Decorator 2
class TimingArraySorterDecorator extends ArraySorterDecorator {
    public TimingArraySorterDecorator(ArraySort arraySort) {
        super(arraySort);
    }

    @Override
    public void sort(int[] array) {
        long startTime = System.currentTimeMillis();
        super.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting took " + (endTime - startTime) + " milliseconds");
    }
}

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArraySorter {
    int[] array;
    ArraySort arraySort;

    public void setSortStrategy(ArraySort arraySort) {
        this.arraySort = arraySort;
    }

    public int[] sort() {
        arraySort.sort(array);
        return array;
    }
}