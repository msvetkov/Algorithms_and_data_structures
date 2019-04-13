package algorithms.sorts;

public class QuickSort {

    public int[] sort(int[] array, int from, int to) {
        if (from < to) {
            int splitIndex = split(array, from, to);

            sort(array, from, splitIndex - 1);
            sort(array, splitIndex + 1, to);
        }
        return array;
    }

    private int split(int[] array, int from, int to) {
        int splitIndex = from - 1;
        int by = array[to];

        for (int i = from; i < to; i++) {
            if (array[i] <= by) {
                splitIndex++;
                array[i] += (array[splitIndex] - (array[splitIndex] = array[i]) ); // swap
            }
        }

        array[to] += (array[splitIndex + 1] - (array[splitIndex + 1] = array[to]) ); // swap
        return splitIndex + 1;
    }

}
