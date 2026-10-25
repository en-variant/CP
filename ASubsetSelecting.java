import java.io.*;
import java.util.*;

public class ASubsetSelecting {
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
        int k = fs.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = fs.nextInt();

        int[] count = new int[101];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        // int val = n/k;
        int res = 0;
        int extra = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                res = i;
                break;
            }
            if (count[i] < k) {
                if (extra + count[i] < k) {
                    res = i;
                    break;
                } else {
                    extra = extra - (k - count[i]);
                }
            } else {
                extra += count[i] - k;
            }
        }
        System.out.println(res);

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