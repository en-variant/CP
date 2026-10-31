import java.io.*;
import java.util.*;

public class BOptimalReduction {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0)
            solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = fs.nextInt();

        boolean possible = true;
        for (int i = 1; i < a.length - 1; i++) {
            /*
             * if (i == 0) {
             * if (a[1] != a[0] - 1 || a[1] != a[0] + 1) {
             * possible = false;
             * }
             * }
             */
            int el = a[i];
            if ((a[i - 1] != el - 1) && (a[i - 1] != el + 1) && (a[i + 1] != el - 1) && (a[i + 1] != el + 1)) {
                possible = false;
            }
        }
        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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