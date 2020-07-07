public class Percolation {

    private boolean[][] grid;
    private int len;
    private int top = 0;
    private int bottom;
    private WeightedQuickUnionUF uf;

    public Percolation(int N) {

        if (N <= 0)
            throw new IllegalArgumentException();
        len = N;
        grid = new boolean[N][N];
        bottom = N * N + 1;
        uf = new WeightedQuickUnionUF(N * N + 2);

    }

    public void open(int i, int j) {

        grid[i - 1][j - 1] = true;

    }

}
