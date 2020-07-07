# Stack and Queue Applications



---

## Arithmetic expression evaluation

ex: ( 1 + ( (2 + 3) * (4 * 5) ) )


**Two-stack algorithm by Dijkstra**

    - Value: push onto the value stack
    - Operator: push onto the operator stack
    - Left parenthesis: ignore
    - Right parenthesis: pop operator and two values; push the result of applying that operator to those values onto the operand stack

```java
public class Evaluate {

    public static void main(String[] args) {

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {

            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() + vals.pop());
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());


    }


}

```

## Coreectness

Q: why correct?
A: when algorithm encounters an operator surrrounded by two values within parenthesis, it leaves the result on the value stack.


---

Quiz

```java
int n = 50;

Stack<Integer> stack = new Stack<Integer>();
while (n > 0) {
    stack.push(n % 2);
    n = n / 2;
}

for (int digit : stack) {
    StdOut.print(digit);
}

StdOut.println();

```

What does the code fragment above print?

A: 110010, It prints the binary representation of n (110010 when n is 50). Note that our stack iterator returns the items in LIFO order, whereas \verb#java.util.Stack#java.util.Stack returns them in FIFO order.
