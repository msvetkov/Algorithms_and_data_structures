package data_structures;

import java.util.Arrays;

public class Queue<T> {


    private static final int INITIAL_SIZE = 512;

    private T[] array =  (T[]) new Object[INITIAL_SIZE];
    private int head = 0;
    private int tail = 0;

    Queue(T... values) {
        for (T value : values) {
           enqueue(value);
        }
    }

    public void enqueue(T value) {
        if (size() >= array.length) {
            increase();
        }
        array[tail++ % array.length] = value;
    }

    public T dequeue() {
        if (isEmpty()) return null;

        T value = array[head % array.length];
        array[head++ % array.length] = null;

        if(isEmpty()) {
            clear();
        }

        int newSize = array.length >> 1;
        if (newSize > INITIAL_SIZE && size() < newSize) {
            decrease();
        }

        return value;
    }

    public int size() {
        return tail - head;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public void clear() {
        head = 0;
        tail = 0;
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
        int newSize = size() + (size() << 1);
        T[] temp = (T[]) new Object[newSize];
        int last = tail % array.length;
        if (last > 0 && last <= head) {
            System.arraycopy(array, 0, temp, array.length-last, last);
        }
        System.arraycopy(array, head, temp, 0, array.length - head);
        array = null;
        array = temp;
        tail = size();
        head = 0;
    }

    private void decrease() {
        int newSize = array.length >> 1;
        T[] temp = (T[]) new Object[newSize];
        int last = tail % array.length;
        if (last <= head) {
            System.arraycopy(array, 0, temp, array.length - head, last);
        }
        System.arraycopy(array, head, temp, 0, size());
        array = null;
        array = temp;
        tail = size();
        head = 0;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append('[');
        for (int i = head; i < tail; i++) {
            strBuilder.append(array[i % array.length].toString());
            if (i + 1 != tail) {
                strBuilder.append(", ");
            }
        }
        strBuilder.append(']');
        return strBuilder.toString();
    }

}
