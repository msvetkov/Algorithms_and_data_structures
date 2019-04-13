package algorithms.sorts;

public class MergeSort {

    public int[] sort(int[] array) {
        if (array.length < 2) {
            return  array;
        }

        int length = array.length;
        int middle = length / 2;

        int firstArray[] = new int[middle];
        int secondArray[] = new int[length - middle];

        System.arraycopy(array, 0, firstArray, 0, middle);
        System.arraycopy(array, middle, secondArray, 0, length - middle);

        firstArray = sort(firstArray);
        secondArray = sort(secondArray);

        return  merge(firstArray, secondArray);
    }

    private int[] merge(int[] firstArray, int[] secondArray) {
        int i = 0, g = 0;
        int array[] = new int[firstArray.length + secondArray.length];

        while (i < firstArray.length || g < secondArray.length) {
            if ( (g == secondArray.length) ||
                    (i < firstArray.length && firstArray[i] <= secondArray[g]) ) {
                array[i + g] = firstArray[i];
                i++;
            } else {
                array[i + g] = secondArray[g];
                g++;
            }
        }
        return  array;
    }

}
