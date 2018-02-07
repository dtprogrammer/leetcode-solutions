package dtprogrammer.github.io.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack implementation backed by resizing array.
 * Reference: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/ResizingArrayStack.java.html
 *
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] items; // array of elements
    private int size; // number of elements in stack

    public ResizingArrayStack() {
        items = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int newCapacity) {
        if (newCapacity < size) {
            throw new IllegalArgumentException();
        }

        Item[] newItems = (Item[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public void push(Item item) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item pop = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return pop;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[size - 1];
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {

        private int current;

        public ReverseIterator() {
            this.current = size - 1;
        }

        @Override
        public boolean hasNext() {
            return current >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current--];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        System.out.println("Stack Size is: " + stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack Size is: " + stack.size());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Stack Size is: " + stack.size());
        System.out.println("Stack top is: " + stack.peek());
        Integer pop = stack.pop();
        System.out.println("Stack pop is: " + pop);
        System.out.println("Stack top is: " + stack.peek());
        System.out.println("Stack Size is: " + stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Stack Size is: " + stack.size());

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
