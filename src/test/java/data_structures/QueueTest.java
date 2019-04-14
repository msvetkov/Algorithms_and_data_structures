package data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void dequeueAndEnqueue() {
        Queue<Integer> queue = new Queue<>(22, 3, -15, 400);
        assertEquals(queue.dequeue(), 22);
        queue.dequeue();
        queue.dequeue();
        assertEquals(queue.dequeue(), 400);

        for (int i = 0; i < 513; i++) {
            queue.enqueue(30);
        }
        for (int i = 0; i < 512; i++) {
            queue.dequeue();
        }
        assertEquals(queue.dequeue(), 30);

    }

    @Test
    void isEmpty() {
        Queue<String> queue = new Queue<>("Hello", ",", " world");
        assertFalse(queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        Queue<Integer> queue = new Queue<>(22, 3, 6, 9, -15, 400);
        assertEquals(queue.size(), 6);
        queue.dequeue();
        queue.dequeue();
        assertEquals(queue.size(), 4);
        for(int i = 0; i < 512; i++) {
            queue.enqueue(500);
        }
        assertEquals(queue.size(), 516);
    }

    @Test
    void clear() {
        Queue<String> queue = new Queue<>("Hello", ",", " world");
        queue.clear();
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());
    }

    @Test
    void contains() {
        Queue<Integer> queue = new Queue<>(22, 3, 6, 9, -15, 400);
        assertEquals(queue.size(), 6);
        queue.dequeue();
        queue.dequeue();
        assertEquals(queue.size(), 4);
        for(int i = 0; i < 512; i++) {
            queue.enqueue(500);
        }
        assertEquals(queue.size(), 516);
    }
}