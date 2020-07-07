import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;
    private int n;

    public RandomizedQueue() {
        arr = (Item[]) new Object[0];

        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return arr.length;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new NoSuchElementException();

        resize(arr.length * 2 + 1);
        arr[n++] = item;

    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {

            temp[i] = arr[i];
        }
        arr = temp;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (n == arr.length / 4)
            resize(arr.length / 2);

        int randomIndex = StdRandom.uniform(n);
        Item item = arr[randomIndex];
        arr[randomIndex] = arr[--n];
        arr[n] = null;
        return item;

    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        return arr[StdRandom.uniform(n)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item> {
        private int i;
        private int[] randomIndices;

        public ArrayIterator() {
            i = 0;
            randomIndices = new int[n];
            for (int j = 0; j < n; j++) {
                randomIndices[j] = j;
            }

            StdRandom.shuffle(randomIndices);
        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return arr[randomIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
