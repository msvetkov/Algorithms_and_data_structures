package algorithms;

import algorithms.sorts.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortsTest {

    @Test
    void insertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        int array[] = {10, 6, -9, 111, 34, 1, 0};
        int actual[] = insertionSort.sort(array);
        int expected[] = {-9, 0, 1, 6, 10, 34, 111};
        assertArrayEquals(expected, actual);
    }

    @Test
    void mergeSort() {
        MergeSort mergeSort = new MergeSort();
        int array[] = {10, 6, -9, 111, 34, 1, 0};
        int actual[] = mergeSort.sort(array);
        int expected[] = {-9, 0, 1, 6, 10, 34, 111};
        assertArrayEquals(expected, actual);
    }

    @Test
    void quickSort() {
        QuickSort quickSort = new QuickSort();
        int array[] = {10, 6, -9, 111, 34, 1, 0};
        int actual[] = quickSort.sort(array, 0, array.length - 1);
        int expected[] = {-9, 0, 1, 6, 10, 34, 111};
        assertArrayEquals(expected, actual);
    }

    @Test
    void countingSort() {
        CountingSort countingSort = new CountingSort();
        int array[] = {10, 6, 9, 111, 34, 1};
        int actual[] = countingSort.sort(array);
        int expected[] = {1, 6, 9, 10, 34, 111};
        assertArrayEquals(expected, actual);
    }

    @Test
    void radixSort() {
        RadixSort radixSort = new RadixSort();
        int array[] = {10, 6, 9, 111, 34, 1};
        int actual[] = radixSort.sort(array);
        int expected[] = {1, 6, 9, 10, 34, 111};
        assertArrayEquals(expected, actual);
    }
}