package data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        Stack<Integer> stack = new Stack<>(22, 3, 6, 9, -15, 400);
        stack.push(15);
        Stack<Integer> expected = new Stack<>(22, 3, 6, 9, -15, 400, 15);
        assertEquals(expected, stack);

        for(int i = 0; i < 512; i++) {
            stack.push(500);
        }
        assertEquals(stack.pop(), 500);
    }

    @Test
    void pop() {
        Stack<String> stack = new Stack<>("Hello", ",", " world");
        for(int i = 0; i < 512; i++) {
            stack.push("another string");
        }

        for(int i = 0; i < 512; i++) {
            stack.pop();
        }

        assertEquals(stack.pop(), " world");

        stack.clear();
        assertNull(stack.pop());
    }

    @Test
    void isEmpty() {
        Stack<String> stack = new Stack<>("Hello", ",", " world");
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void getSize() {
        Stack<Integer> stack = new Stack<>(22, 3, 6, 9, -15, 400);
        assertEquals(stack.getSize(), 6);
        stack.pop();
        stack.pop();
        assertEquals(stack.getSize(), 4);
        for(int i = 0; i < 512; i++) {
            stack.push(500);
        }
        assertEquals(stack.getSize(), 516);
    }

    @Test
    void clear() {
        Stack<String> stack = new Stack<>("Hello", ",", " world");
        stack.clear();
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }

    @Test
    void  contains() {
        Stack<String> stack = new Stack<>("Hello", ",", " world");
        assertTrue(stack.contains(" world"));
        stack.pop();
        assertFalse(stack.contains(" world"));
    }
}