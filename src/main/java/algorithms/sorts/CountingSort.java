package algorithms.sorts;

public class CountingSort {

    public int[] sort(int[] array) {
        int length = array.length;
        int sortedArray[] = new int[length];

        int maxValue = getMax(array);

        // array to count the number of elements for each element not exceeding it
        int countingArray[] = new int[maxValue + 1];

        for (int number : array) {
            countingArray[number]++;
        }
        for (int i = 1; i <= maxValue; i++) {
            countingArray[i] += countingArray[i-1];
        }
        for (int j = (length - 1); j >= 0; j--) {
            sortedArray[countingArray[array[j]] - 1] = array[j];
            countingArray[array[j]]--;
        }
        return sortedArray;
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
