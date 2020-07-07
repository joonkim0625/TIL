import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public Deque() {
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node oldFirst = first;
        first = new Node();
        first.item = item;

        if (isEmpty()) {
            last = first;
            first.next = null;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }

        first.prev = null;
        n++;

    }

    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node oldLast = last;
        last = new Node();
        last.item = item;

        if (isEmpty()) {
            first = last;
            last.prev = null;

        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }

        last.next = null;
        n++;

    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item result = first.item;

        if (n == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }

        n--;
        return result;
    }

    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item result = last.item;

        if (n == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }

        n--;
        return result;
    }

    public Iterator<Item> iterator() {

        return new DequeIterator();

    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public void remove() {
            throw new UnsupportedOperationException();

        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            current = current.next;
            return item;
        }

    }

}
