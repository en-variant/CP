import java.io.*;
import java.util.*;

public class BandCount {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0)
            solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int rows = fs.nextInt();
        int cols = fs.nextInt();
        long pieces = fs.nextLong();
        long queries = fs.nextLong();

        long[][] grid = new long[rows][cols];
        while (pieces-- > 0) {
            int x = fs.nextInt();
            int y = fs.nextInt();

            grid[x - 1][y - 1] = 1;
        }

        long[] rowsSum = new long[rows];
        for (int i = 0; i < rows; i++) {
            long sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j];
            }
            rowsSum[i] = sum;
        }

        long[] colSum = new long[cols];
        for (int i = 0; i < cols; i++) {
            long sum = 0;
            for (int j = 0; j < rows; j++) {
                sum += grid[j][i];
            }
            colSum[i] = sum;
        }

        while (queries-- > 0) {
            int a = fs.nextInt();
            long res = 0;
            if (a == 1) {
                int row = fs.nextInt();
                int k = fs.nextInt();
                for (int i = row - 1; i < k; i++) {
                    res += rowsSum[i];
                }
            } else {
                int col = fs.nextInt();
                int k = fs.nextInt();
                // long res = 0;
                for (int i = col - 1; i < k; i++) {
                    res += colSum[i];
                }
            }

            System.out.println(res);
        }
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr, len;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        String nextToken() throws IOException {
            StringBuilder s = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            while (c > ' ') {
                s.append((char) c);
                c = read();
            }
            return s.toString();
        }

        String next() throws IOException {
            return nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        char nextChar() throws IOException {
            return nextToken().charAt(0);
        }
    }
}