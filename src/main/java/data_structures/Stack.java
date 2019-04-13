package data_structures;

import java.util.Arrays;
import java.util.Objects;

public class Stack<T> {

    private static final int INITIAL_SIZE = 512;

    private T[] array =  (T[]) new Object[INITIAL_SIZE];
    private int currentSize = 0;

    Stack(T... values) {
        for (T value : values) {
            push(value);
        }
    }

    public void push(T value) {
        increase();
        array[currentSize++] = value;
    }

    public T pop(){
        if (isEmpty()) return null;

        T value = array[--currentSize];
        array[currentSize] = null;

        decrease();

        return value;
    }

    public boolean isEmpty() {
        return currentSize <= 0;
    }

    public int size() {
        return currentSize;
    }

    public void clear() {
        array = Arrays.copyOf(array, INITIAL_SIZE);
        currentSize = 0;
    }

    public boolean contains(T value) {
        for (T obj : array) {
            if (value.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    private void increase() {
        if (currentSize >= array.length) {
            int newSize = currentSize + (currentSize << 1);
            array = Arrays.copyOf(array, newSize);
        }
    }

    private void decrease() {
        int newSize = array.length >> 1;
        if (newSize > INITIAL_SIZE && currentSize < newSize) {
            array = Arrays.copyOf(array, newSize);
        }
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append('[');
        for (int i = (currentSize - 1); i >= 0; i--) {
            strBuilder.append(array[i].toString());
            if (i - 1 != 0) {
                strBuilder.append(", ");
            }
        }
        strBuilder.append(']');
        return strBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Stack<?> stack = (Stack<?>) obj;
        return currentSize == stack.currentSize &&
                Arrays.equals(array, stack.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentSize);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
