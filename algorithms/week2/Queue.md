# Queue API

---


```java
public class QueueOfStrings {

    QueueOfStrings() {}

    void enqueue(String item)

    String dequeue()

    boolean isEmpty()

}

```


---

## Queue: linked-list representation

Queue dequeue:

```java
// inner class

private class Node {
    String item;
    Node next;
}


// save item to return
String item = frist.item;

// delete first node

first = first.next;

// return saved item
return item;

```

Queue enqueue:

```java
// save a link to the last node
Node oldlast = last;

// create a new node for the end

Node last = new Node()
last.item = "not"; // an item to be added
last.next = null;

// link the new node to the end of the list

oldlast.next = last;



```

implementation:

```java
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

```

---

## Queue: resizing array implementation

Array implementation of a queue
    - use array q[] to stroe items in queue
    - enqueue(): add new item at q[tail]
    - dequeue(): remove item from q[head]
    - update head and tail modulo the capacity
    - add resizing array

implementation:
```java


```
