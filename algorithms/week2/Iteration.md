# Iteration

Design challenge: support iteration over stack items by client, without revealing the internal representation of the stack

Java solution: make stack implement the Iterable interface


---

## Iterators

Q: what is an Iterable?
A: has a method that returns an Iterator

```java
// iterable interface
public interface Iterable<Item> {
    Iterator<Item> iterator();
}

```

Q: what is an Iterator?
A: has methods hasNext() and next()

```java
public interface Iterator<Item> {
    boolean hasNext();
    Item next();
    // void remove(); <- optional: use at your own risk!!
}

```

Q: what make data structures Iterable?
A: Java supports elegant client code

shorthand
```java
// foreach statement
for (String s: stack)
    StdOut.println(s);

```

equivalent code (longhand)

```java
Iterator<String> i = stack.iterator();
while (i.hasNext()) {
    String s = i.next();
    StdOut.println(s);
}
        
```

---

## Stack iterator: linked-list implementation

```java
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    // ...

    private class ListIterator implement Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { 
            return current != null;
        }

        public void remove() { 
            // not supported so throw UnsupportedOperationException
        }
        
        public Item next() {
            // throw NoSuchElementException if no more items in iteration
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}


```

---

## Stack iterator: array implementation

```java
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    // ...

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() { 
              // not supported
        }

        public Item next() {
            return s[--i];
        }
    }
}

```


--- 

## Bag API

main application - adding items to a collection and iterating(when order doesn't matter)

```java
    public class Bag<Item> implements Iterable<Item>

    Bag() // create an empty bag
    void add(Item x) // insert a new item onto bag
    int size() // number of items in bag
    Iterable<Item> iterator() // iteraotr for items in bag
```

implementation: Stack(without pop) or queue(without dequeue)

---

Quiz: Suppose that we copy the iterator code from our linked list and resizing array implementations of a stack to the corresponding implementations of a queue.
      Which queue iterator(s) will correctly return the items in FIFO order?

Answer: The linked list one, because:

```
The linked-list iterator will work without modification because the items in the linked list are ordered in FIFO order (which is the main reason we dequeue from the front and enqueue to the back instead of vice versa).

The array iterator will fail for two reasons. First, the the items should be iterated over in the opposite order. Second, the items won't typically be stored in the array as entries 0 to n-1n−1.
```


