# Week 1

## Dynamic Connectivity

### Steps to developing a usable algorithm

    - model the problem
    - find an algorithm to solve it
    - fast enough? fits in memory?
    - if not, figure out why
    - find a way to address the problem
    - iterate until satisfied

### When programming, it is convenient to name objects 0 to N-1.

    - use integers as array index
    - suppress details not relevant to union-find

### Modeling the connections

    * We assume "is connected to" is an equivalence relation:
        - reflexive: p is connect to p
        - symmetric: if p is connected to q, then q is connected to p
        - transitive: if p is connected to q and q is connected to r, then p is connected to r

    * Connected components: Maximal set of objects that are mutually connected.
        - ex) { 0 } { 1 4 5 } { 2 3 6 7 } -> 3 connected components

### Implementing operations

    * Find query
        - check if two objects are in the same component

    * Union command
        - replace components containing two objects with their union
        - ex) union(2, 5) -> { 0 } { 1 2 3 4 5 6 7 } from the example above

### Union-find data type (API)

    * Goal: design efficient data structure for union-find
        - number of objects N can be huge
        - number of operations M can be huge
        - find queries and union commands may be intermixed

    ```java

        public class UF {

            UF(int N) // initialize union-find data structure with N objects(0 to N-1)

            void union(int p, int q) // add connection between p and q

            boolean connected(int p, int q) // are p and q in the same component?
        }
    ```

### Dynamic-connectivity client

    * read in number of objects N from standard input
    * repeat:
        - read in pair of integers from standard input
        - if they are not yet connected, connect them and print out pair


