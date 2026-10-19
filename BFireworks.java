
import java.io.*;
import java.util.*;

public class BFireworks {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        long a = fs.nextLong();
        long b = fs.nextLong();
        long k = fs.nextLong();

        long res = (k/a)+(k/b)+2;
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

/* import java.io.*;
import java.util.*;

public class BFireworks {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
        long a = fs.nextLong();
        long b = fs.nextLong();
        long k = fs.nextLong();

        long lcmVal = lcm(a, b);
        long min = Math.min(a, b);
        long x = min+k+1;

        long countA = 0;
        long countB = 0;

        countA += x/a;
        countB += x/b;

        long count = countA+countB+(x/lcmVal);
        out.append(count).append('\n');
    }
    }
    static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((a / gcd(a, b)) * b);
    }
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
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
} */