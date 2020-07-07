# Quick Union

Quick find is too slow, so the alternative can be `Quick Union`.
This is a lazy approach to algorithm design.

---

## Data structure

- integer array id[] of size N
- interpretation: id[i] is parent of i
- root of i is id[id[id[...id[i]...]]]

so, if we have a quick-union data structure on 10 elements that the id[] array is:

`id[i] = {0, 9, 6, 5, 4, 2, 6, 1, 0, 5}`

which are the roots of 3 and 7, respectively?
    - 6 and 6 because:
     - the root of 3 is 6: 3 -> 5 -> 2 -> 6
     - the root of 7 is 6: 7 -> 1 -> 9 -> 5 -> 2 -> 6

- Find method: check if p and q have the same root

- Union method: to merge components containing p and q, set the id of p's root to the id of q's root

```java

public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N) {

        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    private int root(int i) {

        while (i != id[i])
            i = id[i];

        return i;
    }

    public boolean connected(int p, int q) {

        return root(p) == root(q);
    }

    public void union(int p, int q) {

        int i = root(p);
        int j = root(q);

        id[i] = j;
    }

}

```

## Quick union is also too slow

      | algorithm  | initialize   | union   | find  |
        |:---:|:---:|:---:|:---:|
        |  quick-find |  N  | N  | 1   |
        | quick-union | N | N | N |

* Quick-find defect
    - union too expensive (N array accesses)
    - trees are flat, but too expensive to keep them flat

* Quick-union defect
    - trees can get tall
    - find too expensive(could be N array accesses)

---


## Quick-union improvements


### improvement 1: weighting

* weighted quick-union
    - modify quick-union to avoid tall trees
    - keep track of size of each tree(number of objects)
    - balance by linking root of smaller tree to root of larger tree(reasonable alternatives: union by height or "rank")

* Java implementation

    - data structure
        - same as quick-union, but maintain extra array sz[i] to count number of objects in the tree rooted at i

    - find method
        - identical to quick-union
        - `return root(p) == root(q);`

    - union method
        - modify quick-union to:
            - link root of smaller tree to root of large tree
            - update the sz[] array

        ```java
            int i = root(p);
            int j = root(q);
            if (i == j) return;
            if (sz[i] < sz[j]) {

                id[i] = j; 
                sz[j] += sz[i];
            } else {

                id[j] = i;
                sz[i] += sz[j];
           }

        ```

* running time
    - find: takes time proportional to depth of p and q
    - union: take constant time, given roots

* proposition 
    - depth of any node x is at most log N

      | algorithm  | initialize   | union   | find  |
        |:---:|:---:|:---:|:---:|
        |  quick-find |  N  | N  | 1   |
        | quick-union | N | N | N |
        | weighted QU | N | lg N | lg N |



### improvement 2: path compression

Quick union with path compression: just after computing the root of p, set the id of each examined node to point to that root 


* two-pass implementation: add second loop to root() to set the id[] of each examined node to the root

* simpler one-pass variant: make every other node in path point to its grandparent (thereby halving path length)
    ```java
        private int root(int i) {

            while (i != id[i]) {

                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

    ```

* proposition
    - starting from an empty data structure, any sequence of M union-find ops on N objects makes <= c(N + M lg* N) array accesses.
        - analysis can be improved to N + M alpha(M, N)
        - simple algorithm with fascinating mathematics

* linear-time algo for M union-find ops on N objects?
    - cost within constant factor of reading in the data
    - in theory, WQUPC is not quite linear
    - in practice, WQUPC is linear


