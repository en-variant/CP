import java.io.*;
import java.util.*;

public class ANumbersOnTheBoard {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0)
            solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int m = fs.nextInt();
        int n = fs.nextInt();

        if (m == n) {
            System.out.println(0);
            return;
        }
        if (m == 0 || n == 0) {
            System.out.println(Math.abs(m + n) - 1);
            return;
        }
        if (n > 0 && m > 0) {
            int el = Math.abs(m - n);
            System.out.println(el);
        } else if (n < 0 && m < 0) {
            int el = Math.abs(m - n);
            System.out.println(el);
        } else {
            if (Math.abs(m) == Math.abs(n)) {
                System.out.println(0);
            } else if (Math.abs(m) < Math.abs(n)) {
                System.out.println(n - Math.abs(m) - 1);
            } else {
                System.out.println(Math.abs(m) - n - 1);
            }
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