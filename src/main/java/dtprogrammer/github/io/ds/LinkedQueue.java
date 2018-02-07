package dtprogrammer.github.io.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue implementation based on linkedlist
 * Reference: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/LinkedQueue.java.html
 *
 * @param <Item>
 */
public class LinkedQueue<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        Node oldTail = tail;
        tail = new Node(item);
        if (isEmpty()) {
            this.head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;
    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item removed = head.item;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = head;
        }
        return removed;
    }

    public Item peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    public class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        System.out.println("Queue Size is: " + queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue Size is: " + queue.size());
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println("Queue Size is: " + queue.size());
        System.out.println("Queue top is: " + queue.peek());
        Integer pop = queue.dequeue();
        System.out.println("Queue dequeue() is: " + pop);
        System.out.println("Queue top is: " + queue.peek());
        System.out.println("Queue Size is: " + queue.size());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Queue Size is: " + queue.size());

        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
