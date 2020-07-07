# Quick Find

This is a so called eager algorithm.

---

## Data structure

    - integer array `id[]` of size N
    - interpretation: p and q are connected iff they have the same id

    - ex) `id[]` = { 0, 1, 1, 8, 8, 0, 0, 1, 8, 8 }
    - index [0 , 5, 6], index [1, 2, 7], index [3, 4, 8, 9] are connected


    - `find`: check if p and q have the same id
    - `union`: to merge components containing p and q, change all entries whose id equals id[p] to id[q]

## Java implementation

```java

public class QuickFindUF {

    private int [] id;

    public QuickFindUF(int N) {

        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;

    }

    public boolean connected(int p, int q) {

        return id[p] == id[q];
    }

    public void union(int p, int q) {

        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {

            if (id[i] == pid)
                id[i] = qid;
        }
    }
}

```

## Quick-find is too slow

    * Cost model: number of array accesses (for read or write)

        | algorithm  | initialize   | union   | find  |
        |---|---|---|---|
        |  quick-find |  N  | N  | 1   |

    * Quick-find defect: union too expensive

        - takes N^2 array accesses to process sequence of N union commands on N objects


## Quadratic algorithms do not scale

    - let's try to avoid quadratic algorithms..


