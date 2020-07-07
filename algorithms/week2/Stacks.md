# Week 2 

Stacks and Queues

---

# Fundamental data types
    - Value: collection of objects
    - Operations: insert, remove, iterate, test if empty
    - Intent is clear when we insert
    - Which item do we remove?

**Stack**: examine the item most recently added(LIFO - last in first out)
**Queue**: examine the item least recently added(FIFO - first in first out)


---

## Client, implementation, interface

Separate interface and implementation
    - Ex: stack, queue, bag, priority queue, symbol table, union-find ...

Benefits
    - Client can't know details of implementation -> client has many implementation from which to choose
    - Implementation can't know details of client needs -> many clients can re-use the same implementation
    - Design: creates modular, reusable libraries
    - Performance: use optimized implementation where it matters

**Client**: program using operations defined in interface
**Implementation**: actual code implementing operations
**Interface**: description of data type, basic operations

---

## Stacks API

warmup API - stack of strings data type

```java
public class StackOfStrings {

    StackOfStrings();

    void push(String item);

    String pop();

    boolean isEmpty();

    int size();
}

```


---

Stack test client:

    * Read strings from standard input
        * if string equals "-", pop string from stack and print
        * otherwise, push string onto stack

        ```java
        public static void main(String[] args) {

            StackOfStrings stack = new StackOfStrings();
            while (!StdIn.isEmpty()) {
                String s = StdIn.readString();
                if (s.equals("-")) StdOut.print(stack.pop());
                else stack.push(s);
            }
        }
        ```

---

Stack: linked-list representation

Maintain pointer to first node in a linked list; insert/remove from front


**implementation** - using inner class 

```java
private class Node {
    String item;
    Node next;
}

// --- pop ---

public String pop() {
    String item = first.item;

    first = first.next;

    return item;
}

// --- push ---

public void push(String item) {

    Node oldFirst = first;

    first = new Node();
    first.item = item;
    first.next = oldFirst;
    
}

```

implementation:
```java
public class LinkedStackOfStrings {

    private Node first = null;

    // private inner class(access modifiers don't matter)
    private class Node {
        String item;
        Node next;
    }

    public LinkedStackOfStrings() {
    };

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

}
```

---

## Stack: linked-list implementation performance

Proposition: every operation takes constant time in the worst case

Proposition: A stack with N items uses ~ 40 N bytes
    - 16 bytes: object overhead -> every object
    - 8 bytes: inner class extra overhead
    - 8 bytes: reference to String
    - 8 bytes: reference to Node
    - **40** bytes per stack node


---

## Stack: array implementation

Array implementation of a stack
    - use array s[] to store N items on stack
    - push(): add new item at s[N]
    - pop(): remove item from s[N-1]

    ```java
        public class FixedCapacityOfStrings {

            private String[] s;
            private int N = 0;

            // (using capacity as @param is a cheat!!! stay tuned!!)
            // this breaks the api by requiring client to provide capacity
            public FixedCapacityOfStrings(int capacity) {
                s = new String[capacity];
         }

            public boolean isEmpty() {
                return N == 0;
         }

            public void push(String item) {
             s[N++] = item;
         }

            public String pop() {
              return s[--N];
         }

        }
    ```


---

## stack consideration

Overflow and underflow
    - underflow: throw exception if pop from an empty stack
    - overflow: use resizing array for array implementation

Null items: we allow null items to be inserted

Loitering: holding a reference to an object when it is no longer needed
```java
public String pop() {
return s[--N]; // loitering 
}

```

So, not to loiter, we can do:

```java
public String pop() {
    String item = s[--N];
    s[N] = null;
    return item;
}

```

---

## Resizing arrays

Stack: resizing-array implementation

problem: requiring client to provide capacity does not implement API!
Q: How to grow and shrink arry?

First try
    - push(): increase size of array s[] by 1
    - pop(): cecrease size of array s[] by 1

The approach above is too expensive
    - need to copy all item to a new array
    - inserting first N items takes time proportional to 1 + 2 + ... + N ~ N^2 / 2.

Q: how to grow array?
A: if array is full, create a new array of twice(repeated doubling) the size, and copy item

```java
public ResizingArrayStackOfStrings() {

        s = new String[1];

    }

    public void push(String item) {

        if (N == s.length)
            resize(2 * s.length);

        s[N++] = item;

    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
```

Consequence: inserting first N items take proportional to N(not N^2)

Cost of inserting first N items: N + (2 + 4 + 8 + ... + N) ~ 3N

---

Q: how to shrink array?

First try:
    - push(): double size of array s[] when array is full
    - pop(): halve size of array s[] when array is one-half full

Too expensive in worst case
    - consider push-pop-push-pop... sequence when array is full
    - each operation takes time proportional to N

Efficient solution
    - push(): double size of array s[] when array is full
    - pop(): halve size of array s[] when array is one-quarter full

```java
public String pop() {
    String item = s[--N];
    s[N] = null;
    if ( N > 0 && N == s.length / 4 ) 
        resize(s.length / 2);

    return item;
    
}
```
    
Invariant: array is between 25% and 100% full

---

## Stack resizing-array implementation: performance

Amortized analysis: average running time per operation over a worst-case sequence of operations

Proposition: starting from an empty stack, any sequence of M push and pop operations takes time proportional to M

---

## Stack resizing-array implementation: memory usage 

Proposition: uses between ~ 8N and ~ 32N bytes to represent a stack with N items
    - ~8N when full
    - ~32N when one-quarter full

```java
public class ResizingArrayStackOfStrings {

    // 8 bytes -> reference to array
    // 24 bytes -> array overhead
    

    private String[] s; // 8 bytes * array size
    private int N = 0; // 4 bytes (int)
                        // 4 bytes (padding)

}

```

Remark: analysis includes memory for the stack(but not the strings themselves, which the client owns)

---

## Stack implementation: resizing array vs. linked list

Tradeoffs: Can implement a stack with either resizing array or linked list; 
            client can use interchangeably. Which one is better?

Linked-list implementation
    - every operations takes constant time in the worst case
    - uses extra time and space to deal with the links
    - so, it is going to be slower

Resizing-array implementation
    - every operation takes constant amortized time
    - less wasted space
    - probably faster implementation of each operation

So, you would not want to use a resizing-array implementation at the moment that your plance's coming in for a landing.
    - you would not want it to, all of a sudden, not implement some operation quickly
Also, when an internet switch where packets are coming through at a great rate, you would not want to be in a situation where you are missing some data because it got slow all of a sudden.
So, if if I want that guarantee, if I want to be sure that every operation's going to be fast, use linked-list

But, if I don't need that guarantee, if I just care about the total amount of time, I'll probably use the resizing-array because the total will be much less, because individual operations are fast


---

## pop quiz

Suppose that, starting from an empty data structure, we perform n push operations in our resizing-array implementation of a stack. How many times is the resize() method called?

    - logarithmic: the resize() method is called only when the size of the stack is a power of 2. There are ~ log n powers of 2 between 1 and n.








