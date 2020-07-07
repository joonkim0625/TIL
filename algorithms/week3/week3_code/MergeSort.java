public class MergeSort {

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
                a[k] = aux[i++];
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

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi < lo)
            return;

        int mid = lo + (hi - lo) / 2; // computing the value of the mid point
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // do not create this auxiliary array in the recursive routine above!!!
        sort(a, aux, 0, a.length - 1);

    }

    // TODO: helper functions needed

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // check if array is sorted
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

}
