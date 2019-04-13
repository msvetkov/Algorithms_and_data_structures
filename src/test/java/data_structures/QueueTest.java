package data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void dequeue() {
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

}