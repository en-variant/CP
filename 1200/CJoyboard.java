import java.io.*;
import java.util.*;

public class CJoyboard {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        long n = fs.nextLong();
        long m = fs.nextLong();
        long k = fs.nextLong();

        if (k == 1) {
            System.out.println(1);
        }
        else if (k == 2) {
            long val = Math.min(m, n-1);
            if (m >= n) {
                val += m/n;
            }
            System.out.println(val);
        }
        else if (k==3) {
            if (m < n) {
                System.out.println(0);
            } else {
                System.out.println(m - Math.min(m, n - 1) - (m / n));
            }
        }
        else{
            System.out.println(0);
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
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String nextToken() throws IOException {
            StringBuilder s = new StringBuilder();
            int c;
            do { c = read(); } while (c <= ' ' && c != -1);
            while (c > ' ') { s.append((char) c); c = read(); }
            return s.toString();
        }

        String next() throws IOException { return nextToken(); }
        int nextInt() throws IOException { return Integer.parseInt(nextToken()); }
        long nextLong() throws IOException { return Long.parseLong(nextToken()); }
        double nextDouble() throws IOException { return Double.parseDouble(nextToken()); }
        char nextChar() throws IOException { return nextToken().charAt(0); }
    }
}