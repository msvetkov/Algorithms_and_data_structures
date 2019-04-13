package algorithms.sorts;

public class RadixSort {

    public int[] sort(int[] array) {
        int max = getMax(array);

        for (int exp = 1; (max / exp) > 0; exp *= 10) {
            array = countingSortWithExp(array, exp);
        }

        return array;
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

    private int[] countingSortWithExp(int[] array, int exp) {
        int length = array.length;
        int sortedArray[] = new int[length];

        int countingArray[] = new int[10];

        for (int number : array) {
            countingArray[ (number/exp)%10 ]++;
        }

        for (int i = 1; i < 10; i++) {
            countingArray[i] += countingArray[i-1];
        }

        for (int i = (length - 1); i >= 0; i--) {
            sortedArray[ countingArray[ (array[i]/exp)%10 ] - 1] = array[i];
            countingArray[ (array[i]/exp)%10 ] --;
        }
        return sortedArray;
    }
}
