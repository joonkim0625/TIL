# Bottom-up Mergesort, 7/6/2020

Basic plan:
    - pass through array, merging subarrays of size 1
    - repeat for subarrays of size 2, 4, 6, 8, 16, ....

```java

public class MergeBU {

    private MergeBU() {
    }

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++]; // this copying is unnecessary
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}

```

This is a fully complete industrial strength code for sorting. The only downsize is that it uses extra space proportional to the size of the array. 

Q: How many passes (over the input array) does bottom-up mergesort make in the worst case?

A: Logarithmic

