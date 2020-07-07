public class FixedCapacityOfStrings {

    private String[] s;
    private int N = 0;

    // (using capacity as @param is a cheat!!! stay tuned!!)
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
        // the way to prevent loitering
        String item = s[--N];
        s[N] = null;
        return item;
    }

    // resizing...
    // public ResizingArrayStackOfStrings() {

    // s = new String[1];

    // }

    // public void push(String item) {

    // if (N == s.length)
    // resize(2 * s.length);

    // s[N++] = item;

    // }

    // private void resize(int capacity) {
    // String[] copy = new String[capacity];
    // for (int i = 0; i < N; i++) {
    // copy[i] = s[i];
    // }
    // s = copy;
    // }

}
