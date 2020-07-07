# Sorting Complexity, 7/6/2020

Computational complexity: Framework to study efficiency of algorithms for solving a particular problem X

Model of computation: Allowable operations

cost model: Operation count(s)

Upper bound: Cost guarantee provided by some algorithm for X

Lower bound: Proven limit on cost guarantee of all algorithms for X

Optimal algorithm: Algorithm with best(lower bound - upper bound) possible cost gurantee for X

---

Ex:

**Sorting**
    - Model of computation: decision tree <- can access information only through compares(e.g., Java Comparable framework)
    - Cost model: # compares
    - Upper bound: ~ N log N from mergesort
    - lower bound: ?
    - Optimal algorithm: ?

---

## Decision tree (for 3 distinct items a, b, and c)

`a < b` 
    - yes or no? <- code between compares(e.g., sequence of exchangers)
        - if yes, then a < b < c
        -if no, then a < c
            - if yes, then a < c < b
            - if no, then c < a < b

`a < c`
    - if yes, then b < a < c
    - if no, then b < c
        - if yes, then b < c < a
        - if no, then c < b < a

So, in this case, if we go from top to bottom, in the tree with three compares at most, we can determine ordering of the three different items. 
The idea of the lower bound generalizes this argument to figure out a number of compares that you need for a minimum to determine the ordering among N items.


Height of the tree is the worst case number of compares. 

If there is some ordering that is not appeared in a tree corresponding the particular algorithm then that algorithm cannot sort, cannot tell difference between two different orders.

---

## Compare-based lower bound for sorting

Proposition: any compare-based sorting algorithm must use at least log (N!) ~ N log N compares in the worst-case

Proof:
    - assume array consists of N distinct values a1 through aN.
    - worst case dictated by height h of decision tree
    - binary tree of height h has at most 2^h leaves
    - N! different orderings => at least N! leaves
    - 2^h >= # leaves >= N! `==>` h >= log (N!) ~ N log N 

---

## Complexity results in context

Compares?: mergesort is optimal with respect to # compares

Space?: mergesort is not optimal with respect to space usage(mergesort uses twice as extra space proportinal to the size of the array it has to sort)


Lessons: use theory as a guide
    - ex) do not try to design sorting algorithm that guarantees 1/2 N log N compares
    - ex) design sorting algorithm that is both time- and space-optimal

Lower bound may not hold if the algorithm has information about:
    - the initial order of the input
    - the distribution of key values
    - the representation of the keys

    **Partially-ordered arrays** 
        - depending on the initial(insertion sort requires only N-1 compares if input array is sorted) order of the input, we may not need N log N compares

    **Duplicate keys**
        - depending on the input distribution(stay tuned for 3-way quicksort) of duplicates, we may not need N log N compares

    **Digital properties of keys**
        - we can use digit/character compares instead of key compares for numbers and strings

---

Q: Under which of the following scenarios does the N lg N lower bound for sorting apply? Assume that the keys are accessed only through the compareTo() method unless otherwise specified.

A: no two keys are equal.








