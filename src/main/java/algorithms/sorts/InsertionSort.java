package algorithms.sorts;

public class InsertionSort {

    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j+1]) {
                array[j] += (array[j + 1] - (array[j + 1] = array[j]) ); // swap
                j--;
            }
        }
        return array;
    }
}
