# Merge Sort

---

Merge sort is one of the two classic sorting algorithms that are critical components in the world's computational infrastructure.

---

## Idea

Basic plan
    - Divide array into two halves
    - Recursively sort each half
    - Merge two halves


## Abstract demo

We need an auxiliary array to hold the data. First, we copy everything over to the auxiliary array.
Once that is done, we will need to copy back to the original array to get it in sorted order. 
In order to do that, we need to keep three indices:
    - i: the current entry in the left half(the auxiliary array),
    - j: the current entry on the right half(the auxiliary array), 
    - k: the current entry in the sorted result(the original array).

Now, what we need to do is take the smaller of the two entries pointed to by i and j, compare those and take the smallest one between the two and put it into the original array.
If one of the subarrays is exhausted, all we need to do is take the rest of the elements from the other array into the original array(we could optimize this part since we have already copied the elements).

```java

    private MergeSort() {
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // preconditions that these two parts of the original array are sorted
        assert isSorted(a, lo, mid); 
        assert isSorted(a, mid + 1, hi);

        // copying the original array to the auxiliary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge happens:
        int i = lo, j = mid + 1; // set up two pointers

        for (int k = lo; k <= hi; k++) {
            if (i > mid) { // if i pointer is greater than mid, it means the left array is exhausted
                a[k] = aux[j++]; // so just copy the elements
            } else if (j > hi) {
                a[] = aux[i++];
            } else if (less(aux[j], aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }


        }

        assert isSorted(a, lo, hi); // precondition: a[lo..hi] sorted

        // assertion is a good way to debug the process 
        // it makes sure that things are sorted before moving to the next step

    }

```

## Assertions

Assertion: statement to test assumptions about your program
    - helps detect logic bugs
    - documents code

So, Java assert statement throws exception unless boolean condition is true
`assert isSorted(a, lo, hi)`

Can enable or disable at runtime: no cost in production code
`java -ea MyProgram` -> enable assertions
`java -da MyProgram` -> disable assertions (default)

Should not be used for things like checking inputs...

---

## Mergesort: number of compares and array accesses

Mergesort uses at most N lg N compares and 6 N lg N array accesses to sort any array of size N



## Mergesort: memory

Mergesort uses extra space proportional to N because the array aux[] needs to be of size N for the last merge

A sorting algorithm is `in-place` if it uses `<= c lg N extra memory`
ex) insertion sort, selection sort, shellsort

---

## Mergesort: practical improvements

Use insertion sort for small subarrays
    - Mergesort has too much overhead for tiny subarrays
    - cutoff to insertion sort for - 7 times

```java

private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    
    if (hi <= lo + CUTOFF - 1) {
        insertion.sort(a, lo, hi);
        return;
    }

    // ... 
}

```

Stop if already sorted
    - is biggest item in first half <= smallest item in second half?
    - helps for partially-ordered arrays

```java

private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    if (!less(a[mid + 1], a[mid])) return;
    merge(a, aux, lo, mid, hi);
    
    
}

```


Eliminate the copy to the auxiliary array. Save time(but not space) by switching the role of the input and auxiliary array in each recursive call

```java

if (i > mid) aux[k] = a[j++];

// ...

sort(aux, a, lo, mid); 

// ...

```

Q: How many compares does mergesort—the pure version without any optimizations—make to sort an input array that is already sorted?

A: linearithmic, It makes \sim \frac{1}{2} n \log_2 n∼ 
2
1
​	
 nlog 
2
​	
 n compares, which is the best case for mergesort. We note that the optimized version that checks whether a[mid] <= a[mid+1] requires only n - 1 compares.
