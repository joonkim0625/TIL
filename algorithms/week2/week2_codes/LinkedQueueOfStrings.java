public class LinkedQueueOfStrings {

    private Node first, last;

    public LinkedQueueOfStrings() {
    }

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldlast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        // special case for empty queue
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
    }

    public String dequeue() {
        String item = last.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
