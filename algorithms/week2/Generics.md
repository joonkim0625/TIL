# Generics

Parameterized stack using Java generics
    - Avoid casting in client
    - Discover type mismatch errors at compile-time instead of run-time

```java

    Stack<Apple> s = new Stack<Apple>(); // <Apple> -> type parameter
    Apple a = new Apple();
    Orange b = new Orange();
    s.push(a);
    s.push(b); // compile time error
    a = s.pop();

```

**Guiding principles**: Welcome compile-time errors; avoid run time errors!!!


implementation:
```java

public class Stack<Item> {

    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item)  {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;

    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

}


```

---

However, with arrays, it does not quite work...
    - just declare a new array using generic name item 
    - because java does not allow generic array creation

implementation:
```java
public class FixedCapacityStack<Item> {

    private Item[] s;
    private int N = 0;

    public FixedCapacityStack(int capacity) {
        s = (Item[]) new Object[capacity]; //you would want to avoid casting as much as possible...
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }
}

```

What happens after doing that casting:
    - unchecked cast

---

## Generic data types: autoboxing

Q: what to do about primitive types?

**Wrapper type**
    - each primitive type has a wrapper object type
    - ex: Integer is wrapper type for int

**Autoboxing**
    - automatic cast between a primitive type and its wrapper

**Syntactic sugar**
    - behind-the-scenes casting
    ```java
        Stack<Integer> s = new Stack<Integer>();
        s.push(17); // s.push(new Integer(17));
        int a = s.pop(); // int a = s.pop().intValue();
    ``` 

Bottom line
    - client code can use generic stack for any tpye of data
    - Stack<Integer> stack = new Stack<>(); -> you must use a wrapper class instead of primitive types

---

QUIZ

Q: Explain why Java prohibits generic array creation.

Hint: to start, you need to understand that Java arrays are covariant but Java generics are not: that is, String[] is a subtype of Object[], but Stack<String> is not a subtype of Stack<Object>.
